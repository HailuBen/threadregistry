package com.example.demo.services;

import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Saves a product. JPA handles the Brand relationship automatically
     * as long as the Brand object is attached to the Product entity.
     */
    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + id));
    }

    /**
     * Main filter method for the Product List page.
     * This handles Category, Brand (by ID), and Pagination/Sorting.
     */
    public Page<Product> findWithFilters(String category, Long brandId, Pageable pageable) {
        if (category != null && !category.isEmpty() && brandId != null) {
            return productRepository.findByCategoryAndBrandBrandId(category, brandId, pageable);
        } else if (category != null && !category.isEmpty()) {
            return productRepository.findByCategory(category, pageable);
        } else if (brandId != null) {
            return productRepository.findByBrandBrandId(brandId, pageable);
        }
        return productRepository.findAll(pageable);
    }

    // --- Legacy methods maintained for compatibility ---

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Page<Product> findByCategory(String category, Pageable pageable) {
        return productRepository.findByCategory(category, pageable);
    }

    public Page<Product> findByGender(String gender, Pageable pageable) {
        return productRepository.findByGender(gender, pageable);
    }

    public Page<Product> findByCategoryAndGender(String category, String gender, Pageable pageable) {
        return productRepository.findByCategoryAndGender(category, gender, pageable);
    }
}