package com.example.demo.service;

import com.example.demo.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity registerUser(UserEntity user);

    UserEntity getUser(Long id);

    List<UserEntity> getAllUsers();

    UserEntity getByEmail(String email);
}
