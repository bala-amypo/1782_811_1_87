package com.example.demo.service.impl;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.exception.ValidationException;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityCategoryServiceImpl implements ActivityCategoryService {

    @Autowired
    private ActivityCategoryRepository activityCategoryRepository;

    @Override
    public ActivityCategory save(ActivityCategory activityCategory) {
        if (existsByCategoryName(activityCategory.getCategoryName())) {
            throw new ValidationException("Category name already exists");
        }
        return activityCategoryRepository.save(activityCategory);
    }

    @Override
    public Optional<ActivityCategory> findById(Long id) {
        return activityCategoryRepository.findById(id);
    }

    @Override
    public Optional<ActivityCategory> findByCategoryName(String categoryName) {
        return activityCategoryRepository.findByCategoryName(categoryName);
    }

    @Override
    public List<ActivityCategory> findAll() {
        return activityCategoryRepository.findAll();
    }

    @Override
    public ActivityCategory update(Long id, ActivityCategory updatedCategory) {
        ActivityCategory category = activityCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity category not found with id: " + id));
        
        if (updatedCategory.getCategoryName() != null && 
            !updatedCategory.getCategoryName().equals(category.getCategoryName()) &&
            existsByCategoryName(updatedCategory.getCategoryName())) {
            throw new ValidationException("Category name already exists");
        }
        
        if (updatedCategory.getCategoryName() != null) {
            category.setCategoryName(updatedCategory.getCategoryName());
        }
        if (updatedCategory.getDescription() != null) {
            category.setDescription(updatedCategory.getDescription());
        }
        
        return activityCategoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        if (!activityCategoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Activity category not found with id: " + id);
        }
        activityCategoryRepository.deleteById(id);
    }

    @Override
    public boolean existsByCategoryName(String categoryName) {
        return activityCategoryRepository.existsByCategoryName(categoryName);
    }
}