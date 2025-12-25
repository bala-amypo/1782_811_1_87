package com.example.demo.service;

import com.example.demo.entity.ActivityCategory;
import java.util.List;
import java.util.Optional;

public interface ActivityCategoryService {
    ActivityCategory save(ActivityCategory activityCategory);
    Optional<ActivityCategory> findById(Long id);
    Optional<ActivityCategory> findByCategoryName(String categoryName);
    List<ActivityCategory> findAll();
    ActivityCategory update(Long id, ActivityCategory activityCategory);
    void deleteById(Long id);
    boolean existsByCategoryName(String categoryName);
}