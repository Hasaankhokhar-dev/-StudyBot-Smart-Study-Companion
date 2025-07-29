# 📚 StudyBot – Android Student Helper App

**StudyBot** is an interactive Android chatbot app built with **Java** that helps students manage their study schedules, quizzes, and assignments. It mimics a motivational partner or "study buddy" that provides helpful replies, reminders, and positive reinforcement using custom logic and smart keyword detection.

---

## ✨ Features

- 💬 Chat-like interface using `LinearLayout` and dynamic `TextView`
- 🧠 Smart auto-responses based on keyword recognition
- 📝 Encouraging study tips and quiz reminders
- 🚀 Animated bot delay using `Handler` for realism
- 📜 Motivational and supportive message bank
- 📱 Clean Material UI with scrollable chat window

---

## 🧱 Tech Stack

- **Java** – Main programming language
- **XML** – UI layout
- **Android SDK**
- **NestedScrollView & LinearLayout** – Chat UI
- **Custom styles** – For user and bot message bubbles

---

## 🔧 How It Works

1. User sends a message using the input field.
2. The bot checks for **keywords** like `"assignment"`, `"quiz"`, `"deadline"`, `"study"`, etc.
3. Based on logic in `generateUniHelperResponse()`, it replies with relevant and motivational messages.
4. A random fallback message is used when no keywords match.

---

## 🧠 Keyword Detection Logic

Supports contextual replies for:
- 📅 Assignments (due date, start help, idea generation)
- 🧪 Quizzes (topics, preparation tips, timing)
- 🧘‍♀️ Study stress or fatigue
- 🛠 Focus and revision techniques
- 📆 Deadlines and planning
- 👋 Greetings and goodbyes

---



