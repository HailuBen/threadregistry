package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class AuthController {
    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encoder;

    public AuthController(UserRepository userRepo, BCryptPasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

//    @PostMapping("/register")
//    public String processRegister(User user) {
//        user.setPassword(encoder.encode(user.getPassword()));
//        user.setRole("USER"); // Default role
//        userRepo.save(user);
//
//        return "redirect:/login?success";
//    }

    @PostMapping("/register")
    public String processRegister(User user,
                                  @RequestParam("confirmPassword") String confirmPassword,
                                  Model model) {

        System.out.println("DEBUG: Checking username: [" + user.getUsername() + "]");

        // 1. Check if passwords match (compare raw strings)
        assert user.getPassword() != null;
        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match!");
            return "register"; // Return to the form instead of redirecting to keep data
        }

        // 2. Check if username is already taken
        if (userRepo.findByUsername(user.getUsername()).isPresent()) {
            model.addAttribute("error", "Username already exists.");
            return "register";
        }

        // 3. If everything is fine, encode and save
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER");
        userRepo.save(user);

        return "redirect:/login?success";
    }

}