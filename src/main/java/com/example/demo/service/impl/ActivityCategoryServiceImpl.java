package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.service.ActivityCategoryService;

@Service
public class ActivityCategoryServiceImpl implements ActivityCategoryService {

    private final ActivityCategoryRepository repository;

    public ActivityCategoryServiceImpl(ActivityCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ActivityCategory createCategory(ActivityCategory category) {

        repository.findByCategoryName(category.getCategoryName())
                .ifPresent(c -> {
                    throw new RuntimeException("Category name must be unique");
                });

        return repository.save(category);
    }

    @Override
    public ActivityCategory getCategory(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    @Override
    public List<ActivityCategory> getAllCategories() {
        return repository.findAll();
    }
}
