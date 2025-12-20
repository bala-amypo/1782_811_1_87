package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ActivityCategoryEntity;

public interface ActivityCategoryService {

    ActivityCategoryEntity createCategory(ActivityCategoryEntity category);

    ActivityCategoryEntity getCategory(Long id);

    List<ActivityCategoryEntity> getAllCategories();
}
