# threadregistry – Product Catalog Web Application

Thread Registry is a Spring Boot web application for browsing, filtering, and viewing clothing products such as shoes, tops, outerwear, and accessories. The application includes full database persistence, product detail pages with images, and a clean UI built with Thymeleaf and custom CSS.

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
- H2 database for development
- Auto-generated IDs
- Automatic timestamps using `@PrePersist`

---

## Tech Stack

- Java 17
- Spring Boot 4
- Spring MVC
- Spring Data JPA
- Thymeleaf
- H2 Database
- Maven
- Bootstrap + custom CSS

---

## How to Run the Application

### Prerequisites

- Java 17
- Maven (or IntelliJ with Maven support)

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/HailuBen/threadregistry.git
2. Open the project in IntelliJ or your preferred IDE
3. Run the application:
   ```bash
   mvn spring-boot:run
4. Open your browser and visit:
http://localhost:8080

---

## Accessing the H2 Database

Visit the H2 console:
http://localhost:8080/h2-console


Use this JDBC URL:
jdbc:h2:mem:threadregistrydb
