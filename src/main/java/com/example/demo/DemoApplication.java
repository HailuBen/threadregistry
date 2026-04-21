package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        return args -> {
            // Check if admin already exists to avoid duplicates
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                // Set the password to "admin123" encrypted
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole("ADMIN");
                userRepository.save(admin);
                System.out.println(">>> System Admin created: admin / admin123");
            }

            if (userRepository.findByUsername("staff").isEmpty()) {
                User moderator = new User();
                moderator.setUsername("staff");
                moderator.setPassword(passwordEncoder.encode("moderator123"));
                moderator.setRole("MODERATOR"); // Matches hasAnyRole("MODERATOR")
                userRepository.save(moderator);
                System.out.println(">>> Moderator Account Created: staff / moderator123");
            }
        };
    }
}
