package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ActivityLog;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.service.ActivityLogService;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository repository;

    public ActivityLogServiceImpl(ActivityLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public ActivityLog createLog(ActivityLog log) {
        return repository.save(log);
    }

    @Override
    public ActivityLog getLog(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ActivityLog not found with id: " + id));
    }

    @Override
    public List<ActivityLog> getLogsByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<ActivityLog> getLogsByActivityType(Long activityTypeId) {
        return repository.findByActivityTypeId(activityTypeId);
    }

    @Override
    public List<ActivityLog> getAllLogs() {
        return repository.findAll();
    }
}
