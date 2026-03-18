package com.example.demo.services;

import com.example.demo.models.Brand;
import com.example.demo.repositories.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    public Brand findById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid brand ID: " + id));
    }

    /**
     * Finds a brand by its exact name.
     * Useful for looking up a Brand object when you only have a String from a URL.
     */
    public Brand findByName(String name) {
        return brandRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Brand not found with name: " + name));
    }

    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }
}