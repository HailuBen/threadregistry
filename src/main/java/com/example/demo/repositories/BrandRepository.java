package com.example.demo.repositories;

import com.example.demo.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    boolean existsByName(String name);

    // Allows looking up "Nike" to get the Brand object
    Optional<Brand> findByName(String name);
}