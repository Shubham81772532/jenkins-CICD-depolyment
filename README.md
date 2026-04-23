# 🚀 Jenkins CI/CD Pipeline with Docker & ngrok

## 📌 Project Overview

This project demonstrates a complete **CI/CD pipeline** using Jenkins, Maven, Docker, and GitHub Webhooks.
The pipeline automatically builds, tests, and deploys a Java application whenever code is pushed to GitHub.

---

## 🛠️ Tech Stack

* Java (JDK 21)
* Maven
* Jenkins
* Docker
* GitHub
* ngrok

---

## ⚙️ CI/CD Workflow

```text
Git Push → GitHub Webhook → ngrok → Jenkins → Maven Build → Docker Build → Container Deployment
```

---

## 📁 Project Structure

```
.
├── src/
├── pom.xml
├── Dockerfile
├── Jenkinsfile
└── README.md
```

---

## 🔧 Setup Instructions

### 1️⃣ Install Required Tools

* Java (JDK 21)
* Maven
* Docker
* Jenkins

---

### 2️⃣ Start Jenkins

Access Jenkins:

```
http://<your-vm-ip>:8080
```

---

### 3️⃣ Configure Jenkins

* Install Plugins:

  * Git Plugin
  * GitHub Integration Plugin
  * Docker Pipeline Plugin

* Configure Tools:

  * JDK
  * Maven

---

### 4️⃣ Setup GitHub Webhook

Go to GitHub repo:

```
Settings → Webhooks → Add Webhook
```

Set:

```
Payload URL:
https://<ngrok-url>/github-webhook/
```

Content type:

```
application/json
```

---

## 🌐 Using ngrok (Important)

ngrok is used to expose your local Jenkins server to GitHub.

### Start ngrok:

```bash
ngrok http 8080
```

### Example URL:

```
https://abcd1234.ngrok-free.dev
```

👉 Use this in webhook:

```
https://abcd1234.ngrok-free.dev/github-webhook/
```

⚠️ Note:

* ngrok URL changes every restart
* Keep ngrok running

---

## 🐳 Docker Setup

### Build Image:

```bash
docker build -t smart-calculator .
```

### Run Container:

```bash
docker run -d -p 8081:8080 --name smart-container smart-calculator
```

---

## 🧪 Pipeline Stages

1. Checkout Code
2. Build (Maven)
3. Run Tests (JUnit)
4. Package (JAR)
5. Build Docker Image
6. Deploy Container

---

## ▶️ Trigger Pipeline

### Automatic:

* Push code to GitHub

```bash
git add .
git commit -m "update"
git push
```

### Manual:

* Click **Build Now** in Jenkins

---

## 🔍 Verify Deployment

Check running container:

```bash
docker ps
```

Test application:

```bash
curl http://<vm-ip>:8081
```

---

## ❗ Common Issues

### 🔴 Webhook not triggering

* Ensure ngrok is running
* Check webhook URL

### 🔴 Docker permission error

```bash
sudo usermod -aG docker jenkins
sudo systemctl restart jenkins
```

### 🔴 JAVA_HOME issue

* Ensure correct Java path is configured

---

## 📈 Future Improvements

* Push Docker image to Docker Hub
* Deploy to Kubernetes
* Add SonarQube for code quality
* Use AWS EC2 instead of ngrok

---

## 👨‍💻 Author

Shubham Navale

---

## ⭐ Conclusion

This project demonstrates a complete CI/CD pipeline with automated build, test, and deployment using Jenkins and Docker.
