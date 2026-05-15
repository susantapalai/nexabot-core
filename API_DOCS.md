# NexaBot Core API Documentation

> AI-powered WhatsApp automation backend built with Spring Boot, Gemini AI, and Twilio WhatsApp integration.

---

## Overview

NexaBot Core provides REST APIs for:

* Business management
* AI-powered chat automation
* WhatsApp webhook integration
* Chat storage and automation workflows

---

## Base URL

```text
http://localhost:8080
```

---

## Authentication

Currently, authentication is not implemented.

Future recommendation:

* JWT Authentication
* Role-based access control
* API keys for webhook security

---

# NexaBot Core API Endpoints

## Base URL

```text
http://localhost:8080
```

---

# 1. Business APIs

Controller: `BusinessController`

Base Path:

```text
/api/business
```

## 1.1 Get All Businesses

### Endpoint

```http
GET /api/business
```

### Description

Fetch all businesses from database.

### Response

```json
[
  {
    "id": 1,
    "name": "Cafe XYZ",
    "description": "Coffee Shop"
  }
]
```

---

## 1.2 Get Business By ID

### Endpoint

```http
GET /api/business/{id}
```

### Example

```http
GET /api/business/1
```

### Description

Fetch a single business using ID.

### Response

```json
{
  "id": 1,
  "name": "Cafe XYZ"
}
```

---

## 1.3 Create Business

### Endpoint

```http
POST /api/business
```

### Request Body

```json
{
  "name": "Cafe XYZ",
  "description": "Coffee Shop",
  "location": "Bangalore",
  "timings": "9AM - 9PM"
}
```

### Description

Creates a new business.

### Response

```json
{
  "id": 1,
  "name": "Cafe XYZ"
}
```

---

## 1.4 Update Business

### Endpoint

```http
PUT /api/business/{id}
```

### Example

```http
PUT /api/business/1
```

### Request Body

```json
{
  "name": "Updated Cafe",
  "description": "Updated Description"
}
```

### Description

Updates existing business.

### Response

```json
{
  "id": 1,
  "name": "Updated Cafe"
}
```

---

# 2. Chat APIs

Controller: `ChatController`

Base Path:

```text
/api/chat
```

## 2.1 Chat With AI

### Endpoint

```http
POST /api/chat
```

### Request Body

```json
{
  "businessId": "1",
  "message": "What are your opening hours?"
}
```

### Flow

1. Fetch business from DB
2. Build business context
3. Send prompt to Gemini AI
4. Save chat history to DB
5. Return AI response

### Response

```json
{
  "reply": "We are open from 9AM to 9PM",
  "success": true
}
```

### Error Response

```json
{
  "success": false,
  "error": "Business not found"
}
```

---

# 3. WhatsApp Webhook APIs

Controller: `WhatsAppWebhookController`

Base Path:

```text
/webhook
```

## 3.1 Receive WhatsApp Messages

### Endpoint

```http
POST /webhook/whatsapp
```

### Content Type

```text
application/x-www-form-urlencoded
```

### Parameters

| Parameter  | Type   | Required | Description               |
| ---------- | ------ | -------- | ------------------------- |
| Body       | String | Yes      | Customer message          |
| From       | String | Yes      | Customer WhatsApp number  |
| BusinessId | String | No       | Business ID (default = 1) |

### Example Request

```text
Body=Hello
From=whatsapp:+919999999999
BusinessId=1
```

### Flow

1. Receive WhatsApp message from Twilio
2. Fetch business context
3. Generate AI reply using Gemini
4. Save chat in database
5. Send WhatsApp reply using Twilio

### Response

```text
OK
```

### Error Response

```text
Error: <message>
```

---

# Missing APIs / Improvements

## Missing Endpoints

Currently these APIs are NOT implemented:

* DELETE business
* Get all chat messages
* Get chat history by business
* Authentication / JWT login
* Admin dashboard APIs
* Pagination APIs
* Search/filter APIs
* Rate limiting
* API versioning

---

# Suggested Production APIs

## Chat History

```http
GET /api/chat/history/{businessId}
```

## Delete Business

```http
DELETE /api/business/{id}
```

## Dashboard Analytics

```http
GET /api/dashboard/stats
```

## Health Check

```http
GET /health
```

---

# Total APIs Found

| Method | Endpoint           |
| ------ | ------------------ |
| GET    | /api/business      |
| GET    | /api/business/{id} |
| POST   | /api/business      |
| PUT    | /api/business/{id} |
| POST   | /api/chat          |
| POST   | /webhook/whatsapp  |

Total: 6 endpoints

---

# README.md

````md
# NexaBot Core

AI-powered WhatsApp automation platform for businesses.

## Features

- AI chatbot using Gemini API
- WhatsApp integration
- Multi-business support
- Automated FAQ replies
- Chat history storage
- Dashboard-ready backend
- REST APIs
- Docker support

---

## Tech Stack

- Java
- Spring Boot
- MySQL
- Gemini AI API
- Twilio WhatsApp API
- Docker

---

## Architecture

WhatsApp User → Twilio Webhook → Spring Boot → Gemini AI → MySQL Database

---

## API Documentation

See `API_DOCS.md`

---

## Run Locally

### Clone Repository

```bash
git clone https://github.com/susantapalai/nexabot-core.git
````

### Start Application

```bash
./mvnw spring-boot:run
```

---

## Docker Setup

```bash
docker build -t nexabot-core .
docker run -p 8080:8080 nexabot-core
```

---

## Future Improvements

* JWT Authentication
* Admin Dashboard
* Analytics
* SaaS Multi-Tenant System
* Subscription Billing
* AI analytics dashboard

---

## Author

Susanta Sekhar Palai

````

---

# ARCHITECTURE.md

```md
# NexaBot Core Architecture

## System Flow

Customer → WhatsApp → Twilio → Spring Boot API → Gemini AI → Database

---

## Components

### 1. WhatsApp Layer
- Receives customer messages
- Managed using Twilio webhook

### 2. API Layer
- Spring Boot REST APIs
- Handles business logic
- Generates prompts for AI

### 3. AI Layer
- Gemini API integration
- Generates automated responses

### 4. Database Layer
- Stores:
  - Businesses
  - Chat history
  - User messages
  - AI responses

---

## Backend Modules

- Controller Layer
- Service Layer
- Repository Layer
- AI Integration Layer
- Webhook Layer

---

## Future Architecture Goals

- Microservices
- Redis caching
- Kafka event streaming
- Kubernetes deployment
- Multi-tenant SaaS architecture
````

---

# .env.example

```env
GEMINI_API_KEY=
TWILIO_ACCOUNT_SID=
TWILIO_AUTH_TOKEN=
TWILIO_PHONE_NUMBER=
DB_URL=
DB_USERNAME=
DB_PASSWORD=
```

---

# docker-compose.yml

```yaml
version: '3'

services:
  app:
    build: .
    ports:
      - "8080:8080"
    environment:
      - DB_URL=${DB_URL}
      - DB_USERNAME=${DB_USERNAME}
      - DB_PASSWORD=${DB_PASSWORD}
```

---

# Professional Git Commit Messages

## Initial Documentation

```bash
git commit -m "docs: add professional README documentation"
```

## API Documentation

```bash
git commit -m "docs: add complete API documentation"
```

## Architecture Documentation

```bash
git commit -m "docs: add system architecture guide"
```

## Environment Configuration

```bash
git commit -m "chore: add environment example configuration"
```

## Docker Setup

```bash
git commit -m "feat: add docker compose setup"
```

## WhatsApp Integration

```bash
git commit -m "feat: integrate Twilio WhatsApp webhook"
```

## Gemini AI Integration

```bash
git commit -m "feat: add Gemini AI chatbot integration"
```

## Business APIs

```bash
git commit -m "feat: implement business management APIs"
```

## Chat APIs

```bash
git commit -m "feat: add AI chat endpoints"
```

## Refactoring

```bash
git commit -m "refactor: improve service layer architecture"
```

## Bug Fixes

```bash
git commit -m "fix: resolve webhook request handling issue"
```

## Security Improvements

```bash
git commit -m "security: add API validation and sanitization"
```
