package com.example.demo.services;

import com.example.demo.models.Brand;
import com.example.demo.repositories.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }
}
