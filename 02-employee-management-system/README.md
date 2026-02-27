# Employee Management System (Spring Boot + PostgreSQL + Flyway + Docker)

A simple **Employee Management System (EMS)** built with **Spring Boot** and **PostgreSQL**, containerized with **Docker**.  
This module is part of the repo: `dockerizing-spring-application -> 02-employee-management-system`.

✅ **Docker Hub Image:** `karthi222/ems:0.0.1`

---

## Features

- Manage **Departments** and **Employees**
- CRUD operations (Create / Read / Update / Delete)
- PostgreSQL database
- DB migrations using **Flyway**
- Fully dockerized (run using Docker / Docker Compose)

---

## Tech Stack

- Java + Spring Boot
- Spring Web (REST APIs)
- Spring Data JPA (Hibernate)
- PostgreSQL
- Flyway
- Docker / Docker Compose
- Swagger

---

## Database Tables (Example)

Typical EMS schema includes:

### `departments`
- `id (BIGSERIAL PK)`
- `name (unique)`
- `created_at`

### `employees`
- `id (BIGSERIAL PK)`
- `first_name`, `last_name`
- `email (unique)`
- `salary`
- `department_id (FK)`
- `is_active`
- `hire_date`
- `created_at`, `updated_at`

> If you’re using `BIGSERIAL` and insert seed data via Flyway, JPA inserts will work correctly as long as the sequence is in sync (Postgres sequences generally advance correctly unless you manually set IDs).

---

## API Endpoints (Typical)

> Update these paths if your controller mappings are different.

### Employees
- `GET    /api/employees` → list employees
- `GET    /api/employees/{id}` → get employee by id
- `POST   /api/employees` → create employee
- `PUT    /api/employees/{id}` → update employee
- `DELETE /api/employees/{id}` → delete employee

### Departments
- `GET    /api/departments`
- `GET    /api/departments/{id}`
- `POST   /api/departments`
- `PUT    /api/departments/{id}`
- `DELETE /api/departments/{id}`

---

## Run Locally (Without Docker)

### 1) Prerequisites
- Java 21 (or your project Java version)
- Maven
- PostgreSQL running locally

### 2) Configure DB
Update `application.properties` / `application.yml`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ems_db
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=validate
spring.flyway.enabled=true
```

### 3) Start the app
mvn clean spring-boot:run

App runs on:

http://localhost:8080

## Run using Docker (Recommended)
Option A — Pull from Docker Hub & run

Docker image available here: karthi222/ems:0.0.1

### 1) Create a Docker network
docker network create ems-net
### 2) Run PostgreSQL
docker run --name ems-postgres \
  --network ems-net \
  -e POSTGRES_DB=ems_db \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_PASSWORD=postgres \
  -p 5432:5432 \
  -d postgres:latest
### 3) Run EMS app

These env vars are the standard Spring Boot datasource overrides.

docker run --name ems-app \
  --network ems-net \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://ems-postgres:5432/ems_db \
  -e SPRING_DATASOURCE_USERNAME=postgres \
  -e SPRING_DATASOURCE_PASSWORD=postgres \
  -p 8080:8080 \
  -d karthi222/ems:0.0.1

Open:

http://localhost:8085/swagger-ui/index.html

## Run using Docker Compose (Best for local dev)

### Create docker-compose.yml:

name: employee-management-system

services:
  postgres:
    image: postgres:latest
    container_name: ems_postgres
    environment:
      POSTGRES_DB: ems_db
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5432:5432"
    volumes:
      - ems_pgdata:/var/lib/postgresql/data
    restart: unless-stopped

  ems-app:
    image: karthi222/ems:0.0.1
    container_name: ems_app
    depends_on:
      - postgres
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/ems_db
      SPRING_DATASOURCE_USERNAME: postgres
      SPRING_DATASOURCE_PASSWORD: postgres
      # Optional:
      # SPRING_JPA_HIBERNATE_DDL_AUTO: validate
      # SPRING_FLYWAY_ENABLED: "true"
    ports:
      - "8080:8080"
    restart: unless-stopped

volumes:
  ems_pgdata:

### Run:

docker compose up -d

### Logs:

docker compose logs -f ems-app

### Stop:

docker compose down
docker compose down -v (to remove along with volume)

## Build Image Locally (If you want to publish your own tag)

### From the project folder:

mvn clean package -DskipTests
docker build -t karthi222/ems:0.0.1 .
docker push karthi222/ems:0.0.1
Useful Docker Commands
docker ps
docker logs -f ems_app
docker exec -it ems_postgres psql -U postgres -d ems_db
Docker Hub

Image: karthi222/ems

Tag: 0.0.1

## License

This project is for learning and practice.