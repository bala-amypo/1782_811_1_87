
package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity(){
      private long id;
      private String fullName;
      private String email;
      private  String role;
      private  LocalDateTime createdAt;
}