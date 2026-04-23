pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK21'
    }

    environment {
        IMAGE_NAME = "smart-calculator"
        CONTAINER_NAME = "smart-container"
        PORT = "8081"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/YOUR-REAL-REPO.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit '**/target/surefire-reports/*.xml'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t $IMAGE_NAME .'
            }
        }

        stage('Deploy Application') {
            steps {
                sh '''
                docker stop $CONTAINER_NAME || true
                docker rm $CONTAINER_NAME || true
                docker run -d -p $PORT:8080 --name $CONTAINER_NAME $IMAGE_NAME
                '''
            }
        }
    }

    post {
        success {
            echo 'CI/CD Pipeline Successful - App Deployed!'
        }
        failure {
            echo 'Pipeline Failed!'
        }
    }
}