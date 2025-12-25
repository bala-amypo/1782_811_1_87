package com.example.demo.service;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(RegisterRequest request);
    Optional<User> loginUser(LoginRequest request);
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    boolean existsByEmail(String email);
}