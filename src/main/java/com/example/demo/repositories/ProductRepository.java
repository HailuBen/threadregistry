package com.example.demo.repositories;

import com.example.demo.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Filter by Category
    Page<Product> findByCategory(String category, Pageable pageable);

    // Filter by Gender
    Page<Product> findByGender(String gender, Pageable pageable);

    // Filter by Brand ID (Navigates the @ManyToOne relationship)
    Page<Product> findByBrandBrandId(Long brandId, Pageable pageable);

    // Complex Filter: Category + Brand
    Page<Product> findByCategoryAndBrandBrandId(String category, Long brandId, Pageable pageable);

    // Complex Filter: Category + Gender
    Page<Product> findByCategoryAndGender(String category, String gender, Pageable pageable);
}