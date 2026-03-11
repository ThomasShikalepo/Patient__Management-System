# Patient Management Microservice

## Project Overview

This project is a **Patient Management Microservice** built using **Java and Spring Boot** as part of a practice microservices-based healthcare system. The service manages patient-related data such as personal information, contact details, and medical records through RESTful APIs.

The purpose of this project was to gain hands-on experience with **backend service development and microservices architecture**. While building this service, I explored concepts such as **REST API design, layered architecture, database integration with JPA, and service modularization** within a distributed system.

---

## What I Learned

Through this project I gained practical experience with:

- Designing RESTful APIs using **Spring Boot**
- Implementing **layered backend architecture** (Controller, Service, Repository)
- Managing relational data using **Spring Data JPA**
- Structuring applications using **microservices principles**
- Designing services that can integrate with other services in a distributed system
- Containerizing services using **Docker**

---

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- Docker

---

## Architecture

This service follows a **layered architecture**:

- **Controller** – Handles incoming API requests and HTTP endpoints  
- **Service** – Contains the core business logic  
- **Repository** – Handles database interactions using Spring Data JPA  
- **Database** – Stores patient information and records  

This architecture improves **separation of concerns, maintainability, and scalability**.

---

## API Endpoints

| Method | Endpoint | Description |
|------|------|------|
| GET | /patients | Retrieve all patients |
| GET | /patients/{id} | Retrieve a patient by ID |
| POST | /patients | Create a new patient |
| PUT | /patients/{id} | Update patient information |
| DELETE | /patients/{id} | Delete a patient |

---

## Purpose of the Project

This project was created as a **learning project** to better understand backend system design and microservices development. It is intended to be part of a larger distributed healthcare system that may include additional services such as billing, authentication, analytics, and API gateway services.

---

## Author

**Thomas Deon**  
Computer Science Student – Software Development
