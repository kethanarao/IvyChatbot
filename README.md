# 🌿 Herb Harmony

(Work In-Progress)

**An AI-powered chatbot that brings together ancient wisdom from Ayurveda, Traditional Chinese Medicine (TCM), and Korean traditions with modern AI.**

Herb Harmony helps users get personalized food recommendations, herbal remedies, and lifestyle advice based on traditional healing systems — powered by OpenAI.



---

## ✨ Features

- 💬 **Conversational AI Chatbot** — Ask about digestion, energy, skin, stress, sleep, etc.
- 🪔 **Tradition Selection** — Choose between:
  - **Mixed** (balanced blend of all traditions)
  - **Ayurveda** (Doshas, Rasa, Agni)
  - **TCM** (Yin/Yang, Hot/Cold foods, Qi)
  - **Korean** (Fermentation, Yak Sik Dong Won)
- 🥗 **Practical Recommendations** — Food suggestions, simple recipes, herbs & spices
- 🚫 **What to Avoid** — Clear guidance on foods that may worsen your condition
- 📱 **Clean & Modern UI** — Responsive design with beautiful chat experience

---

## 🛠 Tech Stack

- **Backend**: Java 21 + Spring Boot 3.3.4
- **AI Integration**: Spring AI + OpenAI (GPT-3.5-turbo / GPT-4o-mini)
- **Frontend**: Thymeleaf + Bootstrap 5 + Vanilla JavaScript
- **Database**: H2 (in-memory)
- **Build Tool**: Maven

---

## 🚀 Getting Started

### Prerequisites
- Java 21+
- Maven
- OpenAI API Key

### Run Locally

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/herb-harmony.git
2.Add your OpenAI API key in src/main/resources/application.properties
:properties
spring.ai.openai.api-key=YOUR_OPENAI_API_KEY_HERE
3. Run the application:
Bash
./mvnw spring-boot:run

4. Open in browser: http://localhost:8080
