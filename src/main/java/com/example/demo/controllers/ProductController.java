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
        model.addAttribute("product", new Product());
        model.addAttribute("brands", brandService.findAll());
        return "product-form";
    }

    @PostMapping
    public String createProduct(@Valid @ModelAttribute("product") Product product,
                                BindingResult result,
                                Model model) {

        if (result.hasErrors()) {
            model.addAttribute("brands", brandService.findAll());
            return "product-form";
        }

        productService.save(product);
        return "redirect:/products/" + product.getId();
    }

    @GetMapping("/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);

        // Fetch the brand using the product's brandId
        var brand = brandService.findById(product.getBrandId());
        model.addAttribute("product", product);
        model.addAttribute("brand", brand);
        return "product-detail";
    }

    @GetMapping
    public String listProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String gender,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "0") int page,
            Model model) {

        Pageable pageable = PageRequest.of(page, 10, Sort.by(sortBy).ascending());

        Page<Product> products;

        if (category != null && !category.isEmpty() && gender != null && !gender.isEmpty()) {
            products = productService.findByCategoryAndGender(category, gender, pageable);
        } else if (category != null && !category.isEmpty()) {
            products = productService.findByCategory(category, pageable);
        } else if (gender != null && !gender.isEmpty()) {
            products = productService.findByGender(gender, pageable);
        } else {
            products = productService.findAll(pageable);
        }

        model.addAttribute("products", products);
        model.addAttribute("category", category);
        model.addAttribute("gender", gender);
        model.addAttribute("sortBy", sortBy);

        return "product-list";
    }


}
