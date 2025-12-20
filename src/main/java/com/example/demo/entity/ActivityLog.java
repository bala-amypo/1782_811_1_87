package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_logs")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long activityTypeId;
    private Long emissionFactorId;

    private Double quantity;
    private Double emission;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(Long activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public Long getEmissionFactorId() {
        return emissionFactorId;
    }

    public void setEmissionFactorId(Long emissionFactorId) {
        this.emissionFactorId = emissionFactorId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getEmission() {
        return emission;
    }

    public void setEmission(Double emission) {
        this.emission = emission;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
