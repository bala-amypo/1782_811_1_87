package com.example.demo.service;

import com.example.demo.dto.ActivityLogRequest;
import com.example.demo.entity.ActivityLog;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ActivityLogService {
    ActivityLog save(ActivityLogRequest request);
    Optional<ActivityLog> findById(Long id);
    List<ActivityLog> findAll();
    List<ActivityLog> findByUserId(Long userId);
    List<ActivityLog> findByUserIdAndDateRange(Long userId, LocalDate startDate, LocalDate endDate);
    ActivityLog update(Long id, ActivityLogRequest request);
    void deleteById(Long id);
    Double calculateTotalEmissionsByUser(Long userId);
}