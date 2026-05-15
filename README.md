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
- Layered Architecture

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

## Register User

User registers using:

```http
POST /api/auth/register
```

Password gets encrypted using BCrypt and stored in database.

---

## Login User

User logs in using:

```http
POST /api/auth/login
```

JWT token is generated and returned.

---

## Access Protected APIs

Protected APIs require JWT token in Authorization header.

```text
Authorization: Bearer your_jwt_token
```

---

# API Endpoints

# Auth APIs

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/auth/register` | Register user |
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

---

# Request Validation

Validation is implemented using Jakarta Validation.

Examples:
- Empty fields validation
- Email format validation
- Null checks

---

# Exception Handling

Global Exception Handling is implemented using:

```text
@ControllerAdvice
```

Handles:
- Resource not found exception
- Validation exceptions
- General exceptions

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

Application runs on:

```text
http://localhost:8080
```

---

# Testing Using Postman

Postman Collection includes:
- Register API
- Login API
- Add Employee
- Get All Employees
- Get Employee By Id
- Update Employee
- Delete Employee

---

# Security

- Passwords encrypted using BCrypt
- APIs secured using JWT Authentication
- Unauthorized requests are blocked

---

# Future Enhancements

- Role Based Authentication
- Swagger Documentation
- Unit Testing
- Docker Support

---

# Author

Ankit Pathak
