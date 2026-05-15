# NexaBot Core 🚀

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge\&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5-green?style=for-the-badge\&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge\&logo=postgresql)
![Twilio](https://img.shields.io/badge/Twilio-WhatsApp-red?style=for-the-badge\&logo=twilio)
![JWT](https://img.shields.io/badge/Auth-JWT-black?style=for-the-badge\&logo=jsonwebtokens)
![License](https://img.shields.io/badge/License-MIT-purple?style=for-the-badge)

### AI Powered WhatsApp Business Automation Platform

*Built with Spring Boot, Twilio, JWT Security, and Gemini AI.*

</div>

---

## ✨ Features

✅ WhatsApp chatbot integration using Twilio
✅ AI-powered responses with Gemini API
✅ JWT Authentication & Authorization
✅ Business management APIs
✅ Secure Spring Security configuration
✅ PostgreSQL database integration
✅ RESTful API architecture
✅ Chat message handling system
✅ Clean layered architecture

---

## 🛠️ Tech Stack

| Technology      | Usage                      |
| --------------- | -------------------------- |
| Java 17         | Backend Development        |
| Spring Boot 3   | REST API Framework         |
| Spring Security | Authentication & Security  |
| JWT             | Token-based Authentication |
| PostgreSQL      | Database                   |
| Twilio API      | WhatsApp Messaging         |
| Gemini AI       | AI Chat Responses          |
| Maven           | Dependency Management      |
| Lombok          | Boilerplate Reduction      |

---

## 📂 Project Structure

```bash
src/main/java/com/nexabot
│
├── config
│   └── SecurityConfig.java
│
├── controller
│   ├── AuthController.java
│   ├── BusinessController.java
│   ├── ChatController.java
│   └── WhatsAppWebhookController.java
│
├── dto
│   ├── AuthResponse.java
│   ├── ChatRequest.java
│   ├── ChatResponse.java
│   ├── LoginRequest.java
│   └── RegisterRequest.java
│
├── model
│   ├── Business.java
│   ├── ChatMessage.java
│   └── User.java
│
├── repository
│   ├── BusinessRepository.java
│   ├── ChatMessageRepository.java
│   └── UserRepository.java
│
└── service
    ├── AuthService.java
    ├── BusinessService.java
    ├── GeminiService.java
    ├── JwtService.java
    └── TwilioService.java
```

---

## ⚙️ Installation & Setup

### 1️⃣ Clone Repository

```bash
git clone https://github.com/your-username/nexabot-core.git
cd nexabot-core
```

---

### 2️⃣ Configure PostgreSQL

Create a PostgreSQL database:

```sql
CREATE DATABASE nexabot;
```

---

### 3️⃣ Configure Environment Variables

Create an `.env` file or configure in `application.properties`

```properties
# PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/nexabot
spring.datasource.username=postgres
spring.datasource.password=your_password

# JWT
jwt.secret=your_secret_key

# Twilio
TWILIO_ACCOUNT_SID=your_twilio_sid
TWILIO_AUTH_TOKEN=your_twilio_auth_token
TWILIO_WHATSAPP_NUMBER=your_twilio_number

# Gemini AI
GEMINI_API_KEY=your_gemini_api_key
```

---

### 4️⃣ Run the Application

```bash
mvn spring-boot:run
```

Server runs on:

```bash
http://localhost:8080
```

---

## 🔐 Authentication APIs

### Register User

```http
POST /api/auth/register
```

### Login User

```http
POST /api/auth/login
```

Returns JWT token for secured endpoints.

---

## 💬 WhatsApp Integration

This project uses **Twilio WhatsApp Sandbox**.

### Configure Webhook

Set Twilio webhook URL:

```bash
https://your-domain.com/webhook/whatsapp
```

For local development use:

```bash
ngrok http 8080
```

Then paste the generated HTTPS URL into Twilio Sandbox settings.

---

## 🤖 AI Chat Flow

```text
User Message → Twilio Webhook → Spring Boot API → Gemini AI → Response → WhatsApp
```

---

## 📸 API Examples

### 🔐 Register API

```http
POST /api/auth/register
```

#### Request Body

```json
{
  "name": "Prince",
  "email": "prince@example.com",
  "password": "password123"
}
```

#### Response

```json
{
  "message": "User registered successfully",
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

---

### 🔑 Login API

```http
POST /api/auth/login
```

#### Request Body

```json
{
  "email": "prince@example.com",
  "password": "password123"
}
```

#### Response

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "message": "Login successful"
}
```

---

### 🏢 Create Business API

```http
POST /api/business
```

#### Request Body

```json
{
  "businessName": "NexaBot Solutions",
  "category": "AI Automation",
  "phone": "+919999999999"
}
```

#### Response

```json
{
  "id": 1,
  "businessName": "NexaBot Solutions",
  "category": "AI Automation",
  "phone": "+919999999999"
}
```

---

### 📋 Get All Businesses

```http
GET /api/business
```

#### Response

```json
[
  {
    "id": 1,
    "businessName": "NexaBot Solutions",
    "category": "AI Automation"
  },
  {
    "id": 2,
    "businessName": "YogaFlow Studio",
    "category": "Fitness"
  }
]
```

---

### 💬 Chat API

```http
POST /api/chat
```

#### Example 1 — Business Opening Time

##### Request

```json
{
  "message": "What time does your yoga studio open?"
}
```

##### Response

```json
{
  "reply": "Our yoga studio opens daily at 6:00 AM and closes at 9:00 PM 🧘"
}
```

---

#### Example 2 — Appointment Booking

##### Request

```json
{
  "message": "Can I book an appointment for tomorrow at 5 PM?"
}
```

##### Response

```json
{
  "reply": "Yes! Your appointment has been scheduled for tomorrow at 5:00 PM ✅"
}
```

---

#### Example 3 — Pricing Query

##### Request

```json
{
  "message": "What is the monthly membership cost?"
}
```

##### Response

```json
{
  "reply": "Our monthly membership starts from ₹1999 including unlimited classes 💪"
}
```

---

#### Example 4 — Service Availability

##### Request

```json
{
  "message": "Do you provide personal training sessions?"
}
```

##### Response

```json
{
  "reply": "Yes, we provide one-on-one personal training sessions with certified trainers 🏋️"
}
```

---

#### Example 5 — AI Customer Support

##### Request

```json
{
  "message": "I want to know today's offers"
}
```

##### Response

```json
{
  "reply": "Today's special offer: Get 20% discount on yearly membership plans 🎉"
}
```

---

#### Example 6 — WhatsApp Auto Reply

##### Request

```json
{
  "message": "Hello"
}
```

##### Response

```json
{
  "reply": "Hi 👋 Welcome to NexaBot! How can I help you today?"
}
```

---

### 📱 WhatsApp Webhook API

```http
POST /webhook/whatsapp
```

#### Incoming Twilio Payload

```json
{
  "From": "whatsapp:+919999999999",
  "Body": "Hello bot"
}
```

#### Bot Response

```json
{
  "reply": "Hi! Welcome to NexaBot 🚀"
}
```

---

## 🚀 Future Improvements

* Multi-business support
* Admin dashboard
* Analytics system
* Payment integration
* AI workflow automation
* Multi-language support
* Docker deployment
* Kubernetes support

---

## 🧠 Learning Goals From This Project

This project demonstrates:

* Spring Boot backend development
* Secure REST API creation
* JWT authentication flow
* WhatsApp chatbot integration
* AI API integration
* Database management with JPA
* Clean architecture design

---

## 👨‍💻 Author

### Susanta Palai

💡 Passionate about Backend Development, AI Automation & Scalable Systems.

---

## 🌟 Support

If you like this project:

⭐ Star the repository
🍴 Fork the repository
🛠️ Contribute improvements

---

<div align="center">

### Built with ❤️ using Spring Boot & AI

</div>
