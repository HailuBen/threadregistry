package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name is required.")
    private String name;

    @NotBlank(message = "Category is required.")
    private String category;

    @NotBlank(message = "Gender is required.")
    private String gender;

    @NotBlank(message = "Condition is required.")
    private String condition;

    @NotNull(message = "Price is required.")
    private Double price;

    @Size(max = 500)
    private String description;

    @Column(name = "image_url")
    private String imageUrl = "/images/default-placeholder.png"; // Set a default value

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Product() {}

    // Helper for Thymeleaf
    public String getBrandName() {
        return (brand != null) ? brand.getName() : "Unknown Brand";
    }

    // GETTERS AND SETTERS (Crucial for Thymeleaf)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public Brand getBrand() { return brand; }
    public void setBrand(Brand brand) { this.brand = brand; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}