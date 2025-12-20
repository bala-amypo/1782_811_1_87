package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "emission_factors")
public class EmissionFactorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long activityTypeId;

    private String factorName;

    private Double factorValue;

    private String unit;

    // Constructors
    public EmissionFactorEntity() {}

    public EmissionFactorEntity(Long activityTypeId, String factorName, Double factorValue, String unit) {
        this.activityTypeId = activityTypeId;
        this.factorName = factorName;
        this.factorValue = factorValue;
        this.unit = unit;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public Long getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(Long activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public String getFactorName() {
        return factorName;
    }

    public void setFactorName(String factorName) {
        this.factorName = factorName;
    }

    public Double getFactorValue() {
        return factorValue;
    }

    public void setFactorValue(Double factorValue) {
        this.factorValue = factorValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
