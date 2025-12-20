package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ActivityLog;
import com.example.demo.service.ActivityLogService;

@RestController
@RequestMapping("/api/logs")
public class ActivityLogController {

    private final ActivityLogService service;

    public ActivityLogController(ActivityLogService service) {
        this.service = service;
    }

    // POST /api/logs
    @PostMapping
    public ActivityLog createLog(@RequestBody ActivityLog log) {
        return service.createLog(log);
    }

    // GET /api/logs/{id}
    @GetMapping("/{id}")
    public ActivityLog getLog(@PathVariable Long id) {
        return service.getLog(id);
    }

    // GET /api/logs/user/{userId}
    @GetMapping("/user/{userId}")
    public List<ActivityLog> getLogsByUser(@PathVariable Long userId) {
        return service.getLogsByUser(userId);
    }

    // GET /api/logs/activity/{activityTypeId}
    @GetMapping("/activity/{activityTypeId}")
    public List<ActivityLog> getLogsByActivityType(@PathVariable Long activityTypeId) {
        return service.getLogsByActivityType(activityTypeId);
    }

    // GET /api/logs
    @GetMapping
    public List<ActivityLog> getAllLogs() {
        return service.getAllLogs();
    }
}
