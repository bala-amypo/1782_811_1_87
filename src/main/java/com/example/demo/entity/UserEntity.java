
package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalDateTime;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true) 
    private String email;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false, updatable = false) 
    private LocalDateTime createdAt;

    public UserEntity() {
      
        this.createdAt = LocalDateTime.now();
    }

    public UserEntity(String fullName, String email, String role) {
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.createdAt = LocalDateTime.now(); 

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    
}
