package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ActivityLog;

public interface ActivityLogService {

    ActivityLog createLog(ActivityLog log);
    ActivityLog getLog(Long id);
    List<ActivityLog> getLogsByUser(Long userId);
    List<ActivityLog> getLogsByActivityType(Long activityTypeId);
    List<ActivityLog> getAllLogs();
}
