🚀 GtechAi Agent

GtechAi Agent is an AI-powered chatbot application built using Spring Boot for backend and HTML, CSS, JavaScript, Bootstrap for frontend.
It integrates with Gemini API (Google AI) to provide smart responses for user queries.

📌 Features

🌐 Interactive Frontend – Clean UI built with HTML, CSS, Bootstrap, and JavaScript.

⚡ Spring Boot Backend – Handles API requests and responses.

🤖 Gemini AI Integration – Uses API key to connect with Google AI.

💬 Real-time Chat – User can ask questions and get instant AI-powered answers.

🔑 Secure API Calls – API key stored and used securely.

🏗️ Tech Stack

Frontend:

HTML5, CSS3, Bootstrap 5

JavaScript (Fetch API for AJAX calls)

Backend:

Java 17+

Spring Boot (REST API)

Spring Web, Spring DevTools

Maven Build Tool

AI Integration:

Gemini API (Google AI API)

⚙️ Project Structure
GtechAi-Agent
│── src/main/java/com/gtechai
│    ├── controller
│    ├── service
│    ├── model
│    └── GtechAiApplication.java
│
│── src/main/resources
│    ├── static (HTML, CSS, JS files)
│    ├── templates (if using Thymeleaf)
│    └── application.properties
│
│── pom.xml
│── README.md

🔧 Setup & Installation

Clone the repository

git clone https://github.com/your-username/GtechAi-Agent.git
cd GtechAi-Agent


Configure API Key

Open application.properties

Add your Gemini API key:

gemini.api.key=


Run the Spring Boot Application

mvn spring-boot:run




Open index.html in browser OR

Access at http://localhost:7389/
