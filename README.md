# Employee Management System

A Spring Boot based Employee Management System with JWT Authentication, CRUD Operations, Pagination, Sorting, Validation, and Spring Security.

---

# Features

- User Registration and Login
- JWT Authentication and Authorization
- Secure REST APIs using Spring Security
- Employee CRUD Operations
- Pagination and Sorting
- Global Exception Handling
- Request Validation
- MySQL Database Integration
- Postman Collection Included

---

# Tech Stack

- Java 17
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Postman

---

# Project Structure

```text
src/main/java/com/zest/employeemanagement
│
├── config
├── controller
├── dto
├── entity
├── exception
├── repository
├── security
├── service
├── service/impl
└── EmployeeManagementApplication.java
```

---

# Authentication Flow

## Step 1 - Register User

```http
POST /api/auth/register
```

User password is encrypted using BCrypt and stored securely in MySQL database.

---

## Step 2 - Login User

```http
POST /api/auth/login
```

JWT token is generated after successful login.

---

## Step 3 - Access Protected APIs

Use JWT token in Authorization header:

```text
Authorization: Bearer your_jwt_token
```

All Employee APIs are protected using Spring Security.

---

# API Endpoints

# Authentication APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/register` | Register new user |
| POST | `/api/auth/login` | Login user |

---

# Employee APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/employees/add` | Add employee |
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/{id}` | Get employee by ID |
| PUT | `/api/employees/update/{id}` | Update employee |
| DELETE | `/api/employees/delete/{id}` | Delete employee |

---

# Pagination and Sorting

Example:

```http
GET /api/employees?page=0&size=5&sortBy=name
```

Supports:
- Pagination
- Sorting
- Pageable API responses

---

# Validation

Implemented using Jakarta Validation.

Examples:
- Empty field validation
- Email format validation
- Null checks

---

# Exception Handling

Global Exception Handling implemented using:

```text
@ControllerAdvice
```

Handles:
- Resource Not Found Exception
- Validation Exceptions
- General Exceptions

---

# Database Configuration

Create MySQL database:

```sql
CREATE DATABASE employee_db;
```

---

# application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

jwt.secret=VGhpc0lzQVN1cGVyU2VjcmV0S2V5Rm9ySldUQXV0aA==
jwt.expiration=86400000
```

---

# Run Project

## Clone Repository

```bash
git clone YOUR_GITHUB_REPOSITORY_LINK
```

---

## Open Project

Open project in:
- IntelliJ IDEA
- Eclipse
- VS Code

---

## Install Dependencies

```bash
mvn clean install
```

---

## Run Application

Run:

```text
EmployeeManagementApplication.java
```

Application starts on:

```text
http://localhost:8080
```

---

# Postman Collection

Postman Collection is included in the repository.

Collection contains:
- Register User API
- Login User API
- Add Employee API
- Get All Employees API
- Get Employee By ID API
- Update Employee API
- Delete Employee API
- JWT Authentication Testing

Import collection into Postman and test APIs directly.

---

# Security

- JWT Authentication implemented
- Spring Security configured
- Passwords encrypted using BCrypt
- Protected APIs require valid JWT token
- Unauthorized requests are blocked

---

# Future Enhancements

- Role Based Authorization
- Swagger API Documentation
- Unit Testing
- Docker Deployment

---

# Author

## Ankit Pathak


