package com.example.demo.controller;

import com.example.demo.dto.ActivityLogRequest;
import com.example.demo.entity.ActivityLog;
import com.example.demo.service.interfaces.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/activity-logs")
public class ActivityLogController {

    @Autowired
    private ActivityLogService activityLogService;

    @PostMapping
    public ResponseEntity<ActivityLog> createActivityLog(@RequestBody ActivityLogRequest request) {
        return ResponseEntity.ok(activityLogService.save(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityLog> getActivityLog(@PathVariable Long id) {
        return activityLogService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ActivityLog>> getAllActivityLogs() {
        return ResponseEntity.ok(activityLogService.findAll());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ActivityLog>> getActivityLogsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(activityLogService.findByUserId(userId));
    }

    @GetMapping("/user/{userId}/date-range")
    public ResponseEntity<List<ActivityLog>> getActivityLogsByUserAndDateRange(
            @PathVariable Long userId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        return ResponseEntity.ok(activityLogService.findByUserIdAndDateRange(userId, startDate, endDate));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityLog> updateActivityLog(@PathVariable Long id, @RequestBody ActivityLogRequest request) {
        return ResponseEntity.ok(activityLogService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivityLog(@PathVariable Long id) {
        activityLogService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}/total-emissions")
    public ResponseEntity<Double> getTotalEmissionsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(activityLogService.calculateTotalEmissionsByUser(userId));
    }
}