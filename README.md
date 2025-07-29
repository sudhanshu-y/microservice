# Microservice projects


# Microservices - Task 1

This project demonstrates inter-service communication using **Eureka Discovery**, **Micrometer Tracing**, and **AOP-based logging**.

---

## Services Overview

### 0. Eureka Server
- All services register as **Eureka clients**.
- Enables dynamic service discovery (no hardcoded URLs).

### 1. Main Service
- `GET /status` – Returns service status.
- `POST /main` – Calls Hello and Name services, returns combined result.

### 2. Hello Service
- `GET /hello` – Returns `"Hello"`.

### 3. Name Service
- `POST /concatenate` – Accepts `name` and `surname`, returns concatenated string.

---

## Logging & Tracing

- **Custom Annotation**: `@LogMethodParam`
  - Logs method name and input parameters before execution.
  - Implemented using **Spring AOP**.
  
- **Distributed Tracing**: 
  - Powered by **Micrometer Tracing**.
  - Automatically logs `TraceId` for each request across services.

---

## Running the Project

1. **Start Eureka Server** (`eureka-server`)
2. **Run Hello, Name, and Main Services**
   - All services auto-register with Eureka.
3. Test endpoints via Postman, curl, or browser.

---



## Testing Artifacts

Detailed test cases and test results are available in:

- [`Task1-dev-test-artifacts.docx`](./Task1-dev-test-artifacts.docx)

---

# Role Management - Task 2

This project manages role data using an in-memory **H2 database**, with custom role hierarchy building and **AOP-based method logging**.

---

## Features

- Role data loaded via `data.sql`
- Returns nested role structures (parent-child)
- Manual hierarchy logic (no ORM relationships)
- Each role includes a `color` attribute

---


## API Endpoints

- `GET /role/{id}` – Get role by ID
- `GET /allroles` – Get all roles in a nested structure

---

## Database

- **H2 in-memory DB** populated using `data.sql`.
- Roles stored with `id`, `name`, `parentId`, and `color`.

---

## Components

| Class        | Purpose                            |
|--------------|-------------------------------------|
| `Role`       | Entity representing DB role table   |
| `RoleDto`    | Output model for API responses      |
| `RoleMapper` | Converts `Role` to `RoleDto`        |
| `RoleService`| Logic for fetching roles and nesting|

---

## Running the Project

1. Start the service.
2. Access H2 console at `/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`)
3. Use `/role/{id}` and `/allroles` to test functionality.

---

## Testing Artifacts

Detailed test cases and test results are available in:

- [`Task2-dev-test-artifacts.docx`](./Task2-dev-test-artifacts.docx)

---
