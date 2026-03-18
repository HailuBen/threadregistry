package com.example.demo.controllers;

import com.example.demo.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String home(Model model) {
        var allProducts = productService.findAll();

        // 1. Provide the main product list for the "New Arrivals" grid
        model.addAttribute("products", allProducts);

        // 2. Provide the "featuredProducts" for the carousel
        // This prevents the "Property or field 'featuredProducts' cannot be found" error
        // We can just grab the first 3 items as 'featured' for now
        var featured = allProducts.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("featuredProducts", featured);

        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}