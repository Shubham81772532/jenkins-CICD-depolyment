pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK21'
    }

    environment {
        IMAGE_NAME = "smart-calculator"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/your-username/calculator-app.git'
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
                docker stop smart-container || true
                docker rm smart-container || true
                docker run -d -p 8080:8080 --name smart-container $IMAGE_NAME
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