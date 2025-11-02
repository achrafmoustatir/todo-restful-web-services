# 📝 ToDo List API — Spring Boot + JWT Authentication

A complete **RESTful API** built with **Spring Boot**, featuring **JWT-based authentication** and full **CRUD operations** for managing ToDos.

---

## 🚀 Features

✅ **User Registration & Authentication**
- Register a new user with email and password  
- Login using JWT-based authentication  
- Secure all endpoints using JWT tokens  

✅ **ToDo Management**
- Add new ToDo items  
- View all ToDos (user-specific)  
- Update existing ToDos  
- Delete ToDos  

✅ **User Roles & Authorization**
- Differentiate access based on roles (`USER`, `ADMIN`)  
- Admin can view all users and their todos  

---

## 🧰 Tech Stack

- **Java 17+**
- **Spring Boot 3+**
- **Spring Security + JWT**
- **Spring Data JPA**
- **MySQL / H2 Database**
- **Maven**
- **Postman** for API testing

---

## ⚙️ Project Structure

```
src/main/java/com/example/todo/
│
├── config/             # JWT and Security configurations
├── controller/         # REST controllers (AuthController, TodoController)
├── dto/                # Data Transfer Objects (LoginRequest, RegisterRequest, etc.)
├── entity/             # JPA entities (User, Todo)
├── repository/         # Spring Data repositories
├── security/           # JWT utilities and filters
├── service/            # Business logic for Auth and Todo management
└── ToDoApplication.java # Main Spring Boot application
```

---

## 🧑‍💻 API Endpoints

### 🔐 Authentication

| Method | Endpoint             | Description              | Auth Required |
|:-------|:---------------------|:--------------------------|:--------------|
| POST   | `/api/auth/register` | Register new user         | ❌ No          |
| POST   | `/api/auth/login`    | Login and get JWT token   | ❌ No          |

### 🗂️ ToDo CRUD Operations

| Method | Endpoint          | Description             | Auth Required |
|:-------|:------------------|:------------------------|:--------------|
| GET    | `/api/todos`      | Get all ToDos (user)    | ✅ Yes         |
| POST   | `/api/todos`      | Create a new ToDo       | ✅ Yes         |
| PUT    | `/api/todos/{id}` | Update an existing ToDo | ✅ Yes         |
| DELETE | `/api/todos/{id}` | Delete a ToDo           | ✅ Yes         |

---

## 🔧 Configuration

Update your `application.properties`:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=root
spring.datasource.password=

# Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT Secret
app.jwt.secret=YourSecretKeyHere
app.jwt.expiration=86400000
```

---

## ▶️ How to Run

### 1️⃣ Clone the repository
```bash
git clone https://github.com/your-username/todo-list-api.git
cd todo-list-api
```

### 2️⃣ Configure Database
Make sure MySQL (or H2) is running and update the connection details in `application.properties`.

### 3️⃣ Run the app
```bash
mvn spring-boot:run
```

### 4️⃣ Test using Postman
- Register a user → `/api/auth/register`
- Login → get JWT token
- Use token in headers:
  ```
  Authorization: Bearer <your_token_here>
  ```

---

## 🧪 Example JSON

**Register**
```json
{
  "username": "achraf",
  "email": "achraf@example.com",
  "password": "123456"
}
```

**Login**
```json
{
  "email": "achraf@example.com",
  "password": "123456"
}
```

**Add ToDo**
```json
{
  "title": "Finish Spring Boot Project",
  "description": "Implement JWT authentication and CRUD features"
}
```

---

## 📜 License
This project is licensed under the **MIT License** — feel free to use and modify it.

---

## 👨‍💻 Author
**Achraf Moustatir**  
💼 Backend Developer | 💡 Passionate about clean architecture & secure APIs  
📧 your-email@example.com  
🌐 [github.com/achraf-moustatir](https://github.com/achraf-moustatir)
