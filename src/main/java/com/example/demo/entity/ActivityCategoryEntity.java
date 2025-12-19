// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;
// import java.util.List;

// @Entity
// @Table(name = "activity_categories")
// public class ActivityCategoryEntity {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(unique = true)
//     private String categoryName;

//     private String description;

//     private LocalDateTime createdAt;

//     @OneToMany(mappedBy = "category")
//     private List<ActivityTypeEntity> activityTypes;

//     public ActivityCategoryEntity() {}

//     public ActivityCategoryEntity(Long id, String categoryName, String description, LocalDateTime createdAt) {
//         this.id = id;
//         this.categoryName = categoryName;
//         this.description = description;
//         this.createdAt = createdAt;
//     }

//     @PrePersist
//     public void prePersist() {
//         this.createdAt = LocalDateTime.now();
//     }

//     // Getters & Setters
//     public Long getId() { return id; }
//     public void setId(Long id) { this.id = id; }

//     public String getCategoryName() { return categoryName; }
//     public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

//     public String getDescription() { return description; }
//     public void setDescription(String description) { this.description = description; }

//     public LocalDateTime getCreatedAt() { return createdAt; }
// }
