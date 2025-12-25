package com.example.demo.service.interfaces;

import com.example.demo.entity.ActivityType;
import java.util.List;
import java.util.Optional;

public interface ActivityTypeService {
    ActivityType save(ActivityType activityType);
    Optional<ActivityType> findById(Long id);
    List<ActivityType> findAll();
    List<ActivityType> findByCategoryId(Long categoryId);
    ActivityType update(Long id, ActivityType activityType);
    void deleteById(Long id);
}