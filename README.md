# NexaBot Core 🚀

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge\&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5-green?style=for-the-badge\&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge\&logo=postgresql)
![Twilio](https://img.shields.io/badge/Twilio-WhatsApp-red?style=for-the-badge\&logo=twilio)
![Gemini AI](https://img.shields.io/badge/Gemini-AI-purple?style=for-the-badge\&logo=google)
![JWT](https://img.shields.io/badge/Auth-JWT-black?style=for-the-badge\&logo=jsonwebtokens)
![License](https://img.shields.io/badge/License-MIT-success?style=for-the-badge)

# AI Powered WhatsApp Business Automation Platform

### Dynamic AI Chatbot for Real Businesses

*Built using Spring Boot, PostgreSQL, Twilio WhatsApp API & Gemini AI.*

</div>

---

# ✨ Overview

NexaBot Core is a scalable AI-powered backend platform that helps businesses automate customer conversations on WhatsApp.

Instead of using static chatbot replies, NexaBot dynamically reads business data from PostgreSQL and generates intelligent AI responses using Gemini AI.

The system can answer real customer queries like:

* Opening & closing times
* Pricing & membership plans
* Appointment booking
* Available services
* Offers & discounts
* Customer support queries
* Business information

This project is designed as a real-world AI automation SaaS backend.

---

# 🔥 Key Features

✅ AI-powered WhatsApp chatbot
✅ Dynamic business-aware responses
✅ PostgreSQL-driven AI context
✅ JWT Authentication & Authorization
✅ Multi-business scalable architecture
✅ Spring Security integration
✅ RESTful APIs
✅ WhatsApp automation using Twilio
✅ Gemini AI integration
✅ Clean layered architecture
✅ Real-time business support automation

---

# 🛠️ Tech Stack

| Technology      | Purpose                  |
| --------------- | ------------------------ |
| Java 17         | Backend Development      |
| Spring Boot 3   | REST API Framework       |
| Spring Security | Security Layer           |
| JWT             | Authentication           |
| PostgreSQL      | Business Data Storage    |
| Twilio API      | WhatsApp Integration     |
| Gemini AI       | Intelligent AI Responses |
| Maven           | Build Tool               |
| Lombok          | Boilerplate Reduction    |
| JPA/Hibernate   | Database ORM             |

---

# 🧠 How NexaBot Works

```text
Customer Message
       ↓
Twilio WhatsApp Webhook
       ↓
Spring Boot Backend
       ↓
Fetch Business Context From PostgreSQL
       ↓
Generate AI Response Using Gemini AI
       ↓
Send Smart Reply Back To WhatsApp
```

---

# 📂 Project Structure

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
├── security
│   └── JwtAuthenticationFilter.java
│
└── service
    ├── AuthService.java
    ├── BusinessService.java
    ├── GeminiService.java
    ├── JwtService.java
    ├── PromptBuilderService.java
    └── TwilioService.java
```

---

# ⚙️ Installation & Setup

## 1️⃣ Clone Repository

```bash
git clone https://github.com/susantapalai/nexabot-core.git
cd nexabot-core
```

---

## 2️⃣ Configure PostgreSQL

```sql
CREATE DATABASE nexabot;
```

---

## 3️⃣ Configure Environment Variables

Add configuration in `application.properties`

```properties
# PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/nexabot
spring.datasource.username=postgres
spring.datasource.password=your_password

# JWT
jwt.secret=your_secret_key

# Twilio
TWILIO_ACCOUNT_SID=your_sid
TWILIO_AUTH_TOKEN=your_token
TWILIO_WHATSAPP_NUMBER=your_number

# Gemini AI
GEMINI_API_KEY=your_api_key
```

---

## 4️⃣ Run Application

```bash
mvn spring-boot:run
```

Application runs on:

```bash
http://localhost:8080
```

---

# 🔐 Authentication APIs

## Register User

```http
POST /api/auth/register
```

### Request

```json
{
  "name": "Prince",
  "email": "prince@example.com",
  "password": "password123"
}
```

### Response

```json
{
  "message": "User registered successfully",
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

---

## Login User

```http
POST /api/auth/login
```

### Request

```json
{
  "email": "prince@example.com",
  "password": "password123"
}
```

### Response

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "message": "Login successful"
}
```

---

# 💬 Real AI Business Chat Examples

## 🕒 Opening Time Query

### Customer Message

```json
{
  "message": "What time do you open tomorrow?"
}
```

### AI Response

```json
{
  "reply": "We are open from 6:00 AM to 9:00 PM tomorrow 😊"
}
```

---

## 💰 Pricing Query

### Customer Message

```json
{
  "message": "What is your monthly membership price?"
}
```

### AI Response

```json
{
  "reply": "Our monthly membership starts at ₹1999 with unlimited access to all classes 💪"
}
```

---

## 📅 Appointment Booking

### Customer Message

```json
{
  "message": "Can I book an appointment for tomorrow evening?"
}
```

### AI Response

```json
{
  "reply": "Yes! Your appointment has been scheduled for tomorrow at 6 PM ✅"
}
```

---

## 🎉 Offers & Discounts

### Customer Message

```json
{
  "message": "Do you have any offers today?"
}
```

### AI Response

```json
{
  "reply": "Today's special offer: 20% discount on yearly membership plans 🎉"
}
```

---

## 🏋️ Service Availability

### Customer Message

```json
{
  "message": "Do you provide personal training?"
}
```

### AI Response

```json
{
  "reply": "Yes, we provide one-on-one personal training sessions with certified trainers 🏋️"
}
```

---

# 📱 WhatsApp Integration

This project integrates with Twilio WhatsApp Sandbox.

## Configure Webhook URL

```bash
https://your-domain.com/webhook/whatsapp
```

For local development:

```bash
ngrok http 8080
```

Then paste the generated HTTPS URL into your Twilio Sandbox webhook configuration.

---

# 🚀 Future Improvements

* Multi-tenant business support
* AI memory & conversation history
* Admin dashboard
* Payment integration
* Voice AI support
* AI workflow automation
* Analytics dashboard
* Docker deployment
* Kubernetes deployment
* Multi-language AI responses

---

# 🧠 What This Project Demonstrates

This project showcases:

* Scalable Spring Boot architecture
* AI integration in backend systems
* Dynamic AI prompt engineering
* PostgreSQL-driven AI responses
* Secure JWT authentication
* WhatsApp business automation
* Real-world SaaS backend development
* API security & architecture
* Business automation workflows

---

# 👨‍💻 Author

## Susanta Palai

Backend Developer • AI Automation Builder • Spring Boot Developer

Passionate about building scalable AI-powered backend systems and automation products.

---

# 🌟 Support

If you like this project:

⭐ Star the repository
🍴 Fork the repository
🚀 Share with developers
🛠️ Contribute improvements

---

<div align="center">

# Built with ❤️ using Spring Boot, AI & WhatsApp Automation

</div>
