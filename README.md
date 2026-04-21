# threadregistry – Product Catalog Web Application

threadregistry is a Spring Boot web application for browsing, filtering, and viewing clothing products such as shoes, tops, outerwear, and accessories. The application includes full database persistence, product detail pages with images, and a clean UI built with Thymeleaf and custom CSS.      

🚀 Live Demo: https://threadregistry.onrender.com/
(Note: Please allow 30-60 seconds for the free server to wake up.)

---

## Features

### Product Catalog

- Displays all products with images
- Clickable product cards that open a dedicated product detail page
- Category and gender filtering
- Sorting and pagination
- Responsive layout with custom styling

### Product Details

- Full product information
- Large product image
- Brand, category, gender, description, and timestamp
- Clean, user-friendly layout

### Add Product Form

- Form validation
- Brand dropdown
- Image URL support
- Saves directly to the database
- Redirects to the product detail page after saving

### Database Persistence

- Spring Data JPA
- H2 database for development, MySQL for QA/production
- Auto-generated IDs
- Automatic timestamps using `@PrePersist`

---

## Tech Stack

- Java 17
- Spring Boot 4
- Spring MVC
- Spring Data JPA
- Thymeleaf
- H2 Database (dev) / MySQL (QA)
- Docker & Docker Compose
- Maven
- Bootstrap + custom CSS

---

## How to Run the Application

### Option 1 — Docker (QA, MySQL)

**Prerequisites:** Docker and Docker Compose installed.

1. Clone the repository:
```bash
   git clone https://github.com/HailuBen/threadregistry.git
```
2. Start the application:
```bash
   docker-compose up --build
```
3. Open your browser and visit:
   http://localhost:8080

To stop: `docker-compose down`  
To also wipe the database volume: `docker-compose down -v`

### Option 2 — Local Dev (H2)

**Prerequisites:** Java 17, Maven (or IntelliJ with Maven support)

1. Clone the repository:
```bash
   git clone https://github.com/HailuBen/threadregistry.git
```
2. Open the project in IntelliJ or your preferred IDE
3. Run the application:
```bash
   mvn spring-boot:run
```
4. Open your browser and visit:
   http://localhost:8080

---

## Accessing the H2 Database (Dev only)

Visit the H2 console:
http://localhost:8080/h2-console

Use this JDBC URL:
jdbc:h2:mem:testdb

---

## Environment Variables (Docker)

| Variable | Default | Description |
|---|---|---|
| `SPRING_PROFILES_ACTIVE` | `dev` | Set to `qa` for MySQL |
| `MYSQL_HOST` | `mysql` | MySQL hostname |
| `MYSQL_DB` | `threadregistry` | Database name |
| `MYSQL_USER` | `root` | DB username |
| `MYSQL_PASSWORD` | `secret` | DB password |

