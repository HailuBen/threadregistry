package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.services.BrandService;
import com.example.demo.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final BrandService brandService;

    public ProductController(ProductService productService, BrandService brandService) {
        this.productService = productService;
        this.brandService = brandService;
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        Product product = new Product();
        product.setBrand(new com.example.demo.models.Brand()); // Ensure brand isn't null
        model.addAttribute("product", product);
        model.addAttribute("brands", brandService.findAll());
        return "product-form";
    }

    @PostMapping("/save")
    public String createProduct(@Valid @ModelAttribute("product") Product product,
                                BindingResult result,
                                Model model) {

        if (result.hasErrors()) {
            model.addAttribute("brands", brandService.findAll());
            return "product-form";
        }

        // If image is blank, set it to the default so it doesn't try to load an empty string
        if (product.getImageUrl() == null || product.getImageUrl().isBlank()) {
            product.setImageUrl("/images/default-placeholder.png");
        }

        // JPA automatically maps the 'brand.brandId' from the form
        // to the Brand object in the Product entity.
        productService.save(product);
        return "redirect:/products/" + product.getId();
    }

    @GetMapping("/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);

        // Since Product now HAS a Brand object, we don't need a separate service call
        // Unless we want to explicitly pass the 'brand' object to the model
        model.addAttribute("product", product);
        model.addAttribute("brand", product.getBrand());
        return "product-detail";
    }

    @GetMapping
    public String listProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Long brandId, // Changed from String to Long
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "0") int page,
            Model model) {

//        Pageable pageable = PageRequest.of(page, 12, Sort.by(sortBy).ascending());

        // Logic to handle descending price
        Sort sort = sortBy.equals("priceDesc")
                ? Sort.by("price").descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, 12, sort);

        // Use the new consolidated filter method from ProductService
        Page<Product> products = productService.findWithFilters(category, brandId, pageable);

        model.addAttribute("products", products.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", products.getTotalPages());
        model.addAttribute("category", category);
        model.addAttribute("brandId", brandId);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("brands", brandService.findAll()); // For the filter dropdown

        return "product-list";
    }
}