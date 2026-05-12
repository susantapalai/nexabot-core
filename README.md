# NexaBot 🤖
### AI-powered chatbot platform for local businesses

NexaBot helps local businesses automate customer conversations on WhatsApp and Web.
Built with Spring Boot + Google Gemini 2.5 Flash + PostgreSQL.

---

## 🚀 What It Does
- Answers customer questions automatically (menu, timings, location, offers)
- Works on WhatsApp and Web
- Each business gets their own AI-powered chatbot
- Business owners can update their info via dashboard

---

## 🛠️ Tech Stack
| Layer | Technology |
|-------|-----------|
| Backend | Java 17 + Spring Boot 3.5.14 |
| AI Engine | Google Gemini 2.5 Flash |
| Database | PostgreSQL |
| HTTP Client | Spring WebFlux (WebClient) |
| Build Tool | Maven |

---

## ⚙️ Setup & Run Locally

### 1. Clone the repo
```bash
git clone https://github.com/YOURUSERNAME/nexabot-core.git
cd nexabot-core
```

### 2. Create your properties file
```bash
cp application.properties.example src/main/resources/application.properties
```

### 3. Add your keys to application.properties
```properties
gemini.api.key=YOUR_GEMINI_API_KEY_HERE
gemini.api.url=https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent
```

Get your free Gemini API key at: https://aistudio.google.com

### 4. Run the app
```bash
mvn spring-boot:run
```

---

## 📡 API Usage

### Chat Endpoint
POST http://localhost:8080/api/chat
Content-Type: application/json
{
"message": "Do you have veg pizza?",
"businessId": "1"
}
### Response
```json
{
  "reply": "Yes! We have Margherita, Paneer Tikka and Veg Supreme pizzas...",
  "success": true,
  "error": null
}
```

---

## 🗺️ Roadmap
- [x] Day 1 — Gemini AI integration
- [ ] Day 2 — PostgreSQL + multi-business support
- [ ] Day 3 — WhatsApp via Twilio
- [ ] Day 4 — Business owner dashboard
- [ ] Day 5 — Deploy to Railway

---

## 👨‍💻 Built By
Building NexaBot in public — follow the journey on LinkedIn!

> "Helping local businesses automate customer conversations with AI."