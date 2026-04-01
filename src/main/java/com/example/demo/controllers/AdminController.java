package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public AdminController(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<User> users = userRepository.findAll();
        long count = productRepository.count();

//        model.addAttribute("users", userRepository.findAll());
//        model.addAttribute("shoes", productRepository.findAll());

        model.addAttribute("allUsers", users);      // Matches th:each="user : ${allUsers}"
        model.addAttribute("productCount", count);   // Matches th:text="${productCount}"

        model.addAttribute("shoes", productRepository.findAll());

        return "admin/dashboard";
    }

    @PostMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id, @AuthenticationPrincipal UserDetails loggedInUser) {
        // Safety: Find the user to be deleted
        User userToDelete = userRepository.findById(id).orElse(null);

        // Don't let the admin delete themselves (prevents getting locked out)
        if (userToDelete != null && !userToDelete.getUsername().equals(loggedInUser.getUsername())) {
            userRepository.deleteById(id);
        }

        return "redirect:/admin/dashboard";
    }

    @PostMapping("/users/promote/{id}")
    public String promoteUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow();
        user.setRole("MODERATOR");
        userRepository.save(user);
        return "redirect:/admin/dashboard";
    }
}