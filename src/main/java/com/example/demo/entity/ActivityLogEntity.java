package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_logs")
public class ActivityLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActivityTypeEntity activityType;

    @ManyToOne
    private UserEntity user;

    private Double quantity;

    private LocalDate activityDate;

    private LocalDateTime loggedAt;

    private Double estimatedEmission;

    public ActivityLogEntity() {}

    public ActivityLogEntity(Long id, ActivityTypeEntity activityType, UserEntity user, Double quantity,
                             LocalDate activityDate, LocalDateTime loggedAt, Double estimatedEmission) {
        this.id = id;
        this.activityType = activityType;
        this.user = user;
        this.quantity = quantity;
        this.activityDate = activityDate;
        this.loggedAt = loggedAt;
        this.estimatedEmission = estimatedEmission;
    }

    @PrePersist
    public void prePersist() {
        this.loggedAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ActivityTypeEntity getActivityType() { return activityType; }
    public void setActivityType(ActivityTypeEntity activityType) { this.activityType = activityType; }

    public UserEntity getUser() { return user; }
    public void setUser(UserEntity user) { this.user = user; }

    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }

    public LocalDate getActivityDate() { return activityDate; }
    public void setActivityDate(LocalDate activityDate) { this.activityDate = activityDate; }

    public LocalDateTime getLoggedAt() { return loggedAt; }

    public Double getEstimatedEmission() { return estimatedEmission; }
    public void setEstimatedEmission(Double estimatedEmission) { this.estimatedEmission = estimatedEmission; }
}
