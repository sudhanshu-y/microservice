# microservice
microservice projects


# 🚀 Microservices - Task 1

This project demonstrates inter-service communication using **Eureka Discovery**, **Micrometer Tracing**, and **AOP-based logging**.

---

## 🧩 Services Overview

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

## 🔍 Logging & Tracing

- **Custom Annotation**: `@LogMethodParam`
  - Logs method name and input parameters before execution.
  - Implemented using **Spring AOP**.
  
- **Distributed Tracing**: 
  - Powered by **Micrometer Tracing**.
  - Automatically logs `TraceId` for each request across services.

---

## ▶️ Running the Project

1. **Start Eureka Server** (`eureka-server`)
2. **Run Hello, Name, and Main Services**
   - All services auto-register with Eureka.
3. Test endpoints via Postman, curl, or browser.

---

