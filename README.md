# 🎁 Gift Shop Feedback & Rating Management System (Backend)

A full-featured Spring Boot REST API for managing a gift shop’s products, categories, users, feedback, and ratings.  
Designed with clean layered architecture, JPA relationships, MySQL integration, and extensibility for JWT security.

---

## 🚀 Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman (API Testing)

---

## 🏗️ Project Architecture
```text
giftshop/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── prathee/
│   │   │           └── giftshop/
│   │   │               ├── GiftshopApplication.java
│   │   │
│   │   │               ├── controller/
│   │   │               │   ├── CategoryController.java
│   │   │               │   ├── ProductController.java
│   │   │               │   ├── UserController.java
│   │   │               │   ├── FeedbackController.java
│   │   │               │   └── RatingController.java
│   │   │
│   │   │               ├── service/
│   │   │               │   ├── CategoryService.java
│   │   │               │   ├── ProductService.java
│   │   │               │   ├── UserService.java
│   │   │               │   ├── FeedbackService.java
│   │   │               │   ├── RatingService.java
│   │   │               │   ├── CategoryServiceImpl.java
│   │   │               │   ├── ProductServiceImpl.java
│   │   │               │   ├── UserServiceImpl.java
│   │   │               │   ├── FeedbackServiceImpl.java
│   │   │               │   └── RatingServiceImpl.java
│   │   │
│   │   │               ├── repository/
│   │   │               │   ├── CategoryRepo.java
│   │   │               │   ├── ProductRepo.java
│   │   │               │   ├── UserRepo.java
│   │   │               │   ├── FeedbackRepo.java
│   │   │               │   └── RatingRepo.java
│   │   │
│   │   │               ├── model/
│   │   │               │   ├── Category.java
│   │   │               │   ├── Product.java
│   │   │               │   ├── User.java
│   │   │               │   ├── Feedback.java
│   │   │               │   └── Rating.java
│   │   │
│   │   │               ├── exception/
│   │   │               │   ├── GlobalExceptionHandler.java
│   │   │               │   ├── ResourceNotFoundException.java
│   │   │               │   └── BadRequestException.java
│   │   │
│   │   │               ├── aop/
│   │   │               │   └── LoggingAspect.java
│   │   │
│   │   │               ├── configuration/
│   │   │               │   ├── AppConfig.java
│   │   │               │   └── CorsConfig.java
│   │   │
│   │   │               └── security/        (JWT – future)
│   │   │                   ├── JwtUtil.java
│   │   │                   ├── JwtFilter.java
│   │   │                   ├── SecurityConfig.java
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── prathee/
│                   └── giftshop/
│                       └── GiftshopApplicationTests.java
│
└── .gitignore
```



### Architecture Pattern

Controller → Service → Repository → Database

---

## 🗄️ Database Design

### Entities

- Category → One-to-Many → Product
- Product → One-to-Many → Feedback, Rating
- User → One-to-Many → Feedback, Rating

All relationships are enforced using foreign keys.

---

## 📌 API Endpoints

### 🔹 Category APIs

| Method | Endpoint | Description |
|------|---------|-------------|
| POST | `/api/categories` | Create a new category |
| GET | `/api/categories` | Get all categories |
| GET | `/api/categories/{id}` | Get category by ID |
| PUT | `/api/categories/{id}` | Update category |
| DELETE | `/api/categories/{id}` | Delete category |
| GET | `/api/categories/page/{page}/{size}` | Pagination support |

#### Example Request

```json
{
  "categoryName": "Electronics"
}
```
## Product APIs (Simple)

These APIs are used to manage products in the gift shop.

- **POST `/api/products`**  
  → Add a new product  

- **GET `/api/products`**  
  → Get all products  

- **GET `/api/products/{id}`**  
  → Get one product using its ID  

- **PUT `/api/products/{id}`**  
  → Update product details  

- **GET `/api/products/name/{name}`**  
  → Find product by name  

- **GET `/api/products/category/{categoryName}`**  
  → Get products under one category  

⚠️ **Important:**  
A product cannot be created unless its category already exists.

---

##  User APIs (Simple)

These APIs handle users of the system.

- **POST `/api/users`**  
  → Create a new user  

- **GET `/api/users`**  
  → Get all users  

- **GET `/api/users/{id}`**  
  → Get one user by ID  

- **PUT `/api/users/{id}`**  
  → Update user details  

- **GET `/api/users/role/{role}`**  
  → Get users by role  

- **GET `/api/users/username/{username}/role/{role}`**  
  → Filter users using username and role  

---

## Feedback APIs (Simple)

Used when users give feedback on products.

- **POST `/api/feedback`**  
  → Add feedback  

- **GET `/api/feedback/product/{productId}`**  
  → Get feedback for a product  

- **GET `/api/feedback/user/{userId}`**  
  → Get feedback by a user  

---

## Rating APIs (Simple)

Used when users rate products.

- **POST `/api/ratings`**  
  → Add rating  

- **GET `/api/ratings/product/{productId}`**  
  → Get all ratings of a product  

- **GET `/api/ratings/product/{productId}/average`**  
  → Get average rating of a product  

---

## Exception Handling (Simple)

Errors are handled in one place using `GlobalExceptionHandler`.

It handles:
- Data not found  
- Wrong input  
- Database errors  

It sends the correct HTTP status code.

---

## 🔍 AOP (Simple)

Used only for logging.

It logs:
- When a method starts  
- When a method ends  
- How much time it takes  

This keeps logging separate from business code.

---

## 🧪 Testing (Simple)

APIs are tested using **Postman**.

Checked:
- Create, read, update, delete  
- Foreign key rules  
- Pagination  
- Error messages  

---

## 🔐 Security (Later)

Planned features:
- JWT login  
- Role-based access  
- Login and register APIs  

Security is added **after everything works correctly**.

---

## ▶️ How to Run (Simple)

### Create database
```sql
CREATE DATABASE giftshop_db;
```
### Update application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/giftshop_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```
### Run project
```
mvn spring-boot:run

```
### Test APIs 
Use Postman


