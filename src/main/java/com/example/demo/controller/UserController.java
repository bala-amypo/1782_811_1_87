package com.example.demo.controller.UserController;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User", description = "Endpoints for user management")
public class UserController {

    @PostMapping("/register")
    @Operation(summary = "Register a new user")
    public User registerUser(@RequestBody User user) {
        return user;
    }

    @GetMapping("/all")
    @Operation(summary = "List all users")
    public List<User> getAllUsers() {
        return List.of();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by ID")
    public User getUserById(@PathVariable Long id) {
        return new User();
    }
}
