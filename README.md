# 📌 To-Do List API

A simple and efficient **RESTful API** for managing tasks in a To-Do List. Built using **Java Spring Boot**, this backend service enables users to create, update, delete, and retrieve tasks with minimal setup. Perfect for learning, personal productivity tools, or integrating into larger systems.

---

## 🚀 Features

- ✅ Create new tasks with title and description
- ✅ Retrieve all tasks or a specific task by ID
- ✅ Update task details
- ✅ Mark tasks as completed or pending
- ✅ Delete tasks permanently
- ✅ Clean and structured JSON responses
- ✅ Built with standard RESTful architecture

---

## 🛠️ Tech Stack

| Layer       | Technology                 |
|-------------|----------------------------|
| **Backend** | Java 17, Spring Boot       |
| **Database**| H2 (In-Memory)             |
| **Build Tool** | Maven / Gradle         |
| **Testing** | Postman / Curl             |

---

## 📂 Project Structure

todo-api/

├── src/

│ ├── main/

│ │ ├── java/

│ │ │ └── com/example/todo/

│ │ │ ├── controller/

│ │ │ ├── model/

│ │ │ ├── repository/

│ │ │ └── service/

│ │ └── resources/

│ │ ├── application.properties

├── pom.xml / build.gradle

└── README.md




---

## 📬 API Endpoints

| Method | Endpoint         | Description               |
|--------|------------------|---------------------------|
| GET    | `/tasks`         | Get all tasks             |
| GET    | `/tasks/{id}`    | Get task by ID            |
| POST   | `/tasks`         | Create new task           |
| PUT    | `/tasks/{id}`    | Update task by ID         |
| DELETE | `/tasks/{id}`    | Delete task by ID         |

📌 All responses are in JSON format.

---

## 🔧 Running the Project

### 🔹 Using Maven

```bash
./mvnw spring-boot:run

🧪 Testing with Postman
Import your endpoints in Postman and test easily. You can also use:

curl -X GET http://localhost:8080/tasks


🎯 Purpose & Learning
This project was built to:

Understand how REST APIs work using Spring Boot

Learn about request handling, services, repositories, and models

Practice using Java with real-world use cases

Serve as a base for larger task/project management systems





