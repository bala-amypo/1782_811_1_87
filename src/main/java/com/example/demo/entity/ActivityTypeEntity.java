package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "activity_types")
public class ActivityTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String typeName;

    @ManyToOne
    private ActivityCategoryEntity category;

    private String unit;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "activityType")
    private List<ActivityLogEntity> activityLogs;

    @OneToMany(mappedBy = "activityType")
    private List<EmissionFactorEntity> emissionFactors;

    public ActivityTypeEntity() {}

    public ActivityTypeEntity(Long id, String typeName, ActivityCategoryEntity category, String unit, LocalDateTime createdAt) {
        this.id = id;
        this.typeName = typeName;
        this.category = category;
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

    public String getTypeName() { return typeName; }
    public void setTypeName(String typeName) { this.typeName = typeName; }

    public ActivityCategoryEntity getCategory() { return category; }
    public void setCategory(ActivityCategoryEntity category) { this.category = category; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
