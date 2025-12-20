package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ActivityTypeEntity;

public interface ActivityTypeService {

    ActivityTypeEntity createType(Long categoryId, ActivityTypeEntity type);

    ActivityTypeEntity getType(Long id);

    List<ActivityTypeEntity> getTypesByCategory(Long categoryId);
}
