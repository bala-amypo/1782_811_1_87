package com.example.demo.dto;

import java.time.LocalDate;

public class ActivityLogRequest {
    private Long userId;
    private Long activityTypeId;
    private Double quantity;
    private LocalDate activityDate;

    public ActivityLogRequest() {}

    public ActivityLogRequest(Long userId, Long activityTypeId, Double quantity, LocalDate activityDate) {
        this.userId = userId;
        this.activityTypeId = activityTypeId;
        this.quantity = quantity;
        this.activityDate = activityDate;
    }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getActivityTypeId() { return activityTypeId; }
    public void setActivityTypeId(Long activityTypeId) { this.activityTypeId = activityTypeId; }
    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }
    public LocalDate getActivityDate() { return activityDate; }
    public void setActivityDate(LocalDate activityDate) { this.activityDate = activityDate; }
}