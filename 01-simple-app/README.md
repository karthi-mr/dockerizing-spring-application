# 01 - Simple Spring Boot App (Dockerized)

A minimal Spring Boot application containerized with Docker.  
This module shows the **end-to-end flow**: build JAR ➜ build Docker image ➜ run container ➜ test endpoint.

---

## Tech Stack
- Java (JDK 17/21)
- Spring Boot
- Maven
- Docker

---

## Project Structure (example)

01-simple-app/
├── src/
├── pom.xml
├── Dockerfile
└── README.md


---

## Prerequisites
Make sure you have:
- Java installed (`java -version`)
- Maven installed (`mvn -v`)
- Docker installed (`docker -v`)

---

## Run Locally (without Docker)

### 1) Build the application
```bash
mvn clean package
```
### 2) Run the JAR
```bash
java -jar target/*.jar
```

### 3) Test

Open in browser:

http://localhost:8080/
(If your controller endpoint is different, update this link.)

---

## Run with Docker
### 1) Build JAR
```bash
mvn clean package
```

### 2) Build Docker image
```bash
From inside 01-simple-app folder:
docker build -t simple-spring-app:1.0 .
```

### 3) Run Docker container
```bash
docker run --name simple-spring-app -p 8080:8080 --rm simple-spring-app:1.0
```

### 4) Test endpoint
http://localhost:8080/


## Useful Docker Commands

- List images 
  - docker images
- List running containers 
  - docker ps
- Stop container
  - docker stop simple-spring-app

## Notes

If your Spring Boot app runs on a different port (example: 9090), update:

Docker run: -p 9090:9090

And your application properties/yaml accordingly.

Author

Karthi M
GitHub: https://github.com/karthi-mr
