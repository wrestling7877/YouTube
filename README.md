# YouTube Backend API

A Spring Boot backend application for a YouTube-like video platform.

## Features

* User Authentication with JWT
* Profile Management
* Video Management
* Channel Management
* Category Management
* Attachment Management
* Email Verification
* Global Exception Handling
* Database Migration with Flyway

## Tech Stack

* Java 17
* Spring Boot 3
* Spring Security
* Spring Data JPA
* JWT
* PostgreSQL
* Flyway
* Lombok
* Maven
* Swagger / OpenAPI

## Project Structure

```text
src/main/java/com/example
├── config
├── controller
├── dto
├── entity
├── enums
├── repository
├── service
└── util
```

## Database

PostgreSQL is used as the primary database.

Database migrations are managed with Flyway.

## How to Run

### 1. Clone Repository

```bash
git clone https://github.com/wrestling7877/YouTube.git
cd YouTube
```

### 2. Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/database_name
spring.datasource.username=postgres
spring.datasource.password=password
```

### 3. Run Application

```bash
./mvnw spring-boot:run
```

## API Documentation

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

## Author

**Bekzod**

Java Backend Developer

Technologies:

* Spring Boot
* PostgreSQL
* JWT
* Flyway
* Spring Security
* REST API Development

```
```
