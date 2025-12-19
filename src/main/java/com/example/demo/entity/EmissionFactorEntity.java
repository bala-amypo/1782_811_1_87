package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "emission_factors")
public class EmissionFactorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ActivityTypeEntity activityType;

    private Double factorValue;

    private String unit;

    private LocalDateTime createdAt;

    public EmissionFactorEntity() {}

    public EmissionFactorEntity(Long id, ActivityTypeEntity activityType, Double factorValue, String unit, LocalDateTime createdAt) {
        this.id = id;
        this.activityType = activityType;
        this.factorValue = factorValue;
        this.unit = unit;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ActivityTypeEntity getActivityType() { return activityType; }
    public void setActivityType(ActivityTypeEntity activityType) { this.activityType = activityType; }

    public Double getFactorValue() { return factorValue; }
    public void setFactorValue(Double factorValue) { this.factorValue = factorValue; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
