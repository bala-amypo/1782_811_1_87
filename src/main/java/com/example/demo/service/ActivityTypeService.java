package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ActivityType;

public interface ActivityTypeService {

    ActivityType createType(Long categoryId, ActivityType type);

    ActivityType getType(Long id);

    List<ActivityType> getTypesByCategory(Long categoryId);
}
