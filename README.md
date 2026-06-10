# YouTube Backend API

A Spring Boot REST API inspired by the YouTube platform.

This project provides backend services for user authentication, channel management, video publishing, categories, tags, video interactions, and file uploads.

## Features

* JWT Authentication & Authorization
* User Registration and Login
* Email Verification
* Profile Management
* Channel Management
* Video Management
* Category Management
* Tag Management
* Video Like System
* Video View Counter
* File Upload & Attachment Management
* Global Exception Handling
* Validation
* Swagger API Documentation

## Tech Stack

* Java 17
* Spring Boot 3
* Spring Security
* Spring Data JPA
* PostgreSQL
* JWT
* Lombok
* Maven
* Swagger / OpenAPI
* Java Mail Sender

## Project Structure

```text
src/main/java/com/example
├── config
├── controller
├── dto
├── entity
├── repository
├── service
├── util
└── exception
```

## Main Modules

### Authentication

* Registration
* Login
* JWT Token Generation
* Email Verification

### Profile

* Create Profile
* Update Profile
* Profile Management

### Channel

* Create Channel
* Update Channel
* Delete Channel

### Video

* Upload Video
* Update Video
* Delete Video
* Video Listing
* Video Details

### Category

* Create Category
* Update Category
* Delete Category

### Tag

* Create Tag
* Update Tag
* Delete Tag

### Video Interaction

* Video Likes
* Video Views Counter

### Attachment

* Upload Files
* Download Files
* Manage Attachments

## Database

PostgreSQL is used as the primary database.

The application stores:

* Profiles
* Channels
* Videos
* Categories
* Tags
* Video Likes
* Video Views
* Attachments

## How to Run

### 1. Clone Repository

```bash
git clone https://github.com/wrestling7877/YouTube.git
cd YouTube
```

### 2. Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/youtube_db
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

## Future Improvements

* Video Comments
* Playlist Management
* Subscription System
* Recommendation Engine
* Redis Caching
* Docker Support

## Author

**Bekzod**

Java Backend Developer

Technologies:

* Spring Boot
* PostgreSQL
* JWT
* Spring Security
* REST API Development
* JPA / Hibernate
* Swagger
