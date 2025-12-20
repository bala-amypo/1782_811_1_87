package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ActivityCategoryEntity;
import com.example.demo.entity.ActivityTypeEntity;
import com.example.demo.repository.ActivityCategoryRepository;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    private final ActivityTypeRepository typeRepository;
    private final ActivityCategoryRepository categoryRepository;

    public ActivityTypeServiceImpl(
            ActivityTypeRepository typeRepository,
            ActivityCategoryRepository categoryRepository) {
        this.typeRepository = typeRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ActivityTypeEntity createType(Long categoryId, ActivityTypeEntity type) {

        if (type.getUnit() == null || type.getUnit().isBlank()) {
            throw new RuntimeException("Unit must be provided");
        }

        typeRepository.findByTypeName(type.getTypeName())
                .ifPresent(t -> {
                    throw new RuntimeException("Type name must be unique");
                });

        ActivityCategoryEntity category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new RuntimeException("Category not found with id: " + categoryId));

        type.setCategory(category);
        return typeRepository.save(type);
    }

    @Override
    public ActivityTypeEntity getType(Long id) {
        return typeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Type not found with id: " + id));
    }

    @Override
    public List<ActivityTypeEntity> getTypesByCategory(Long categoryId) {

        ActivityCategoryEntity category = categoryRepository.findById(categoryId)
                .orElseThrow(() ->
                        new RuntimeException("Category not found with id: " + categoryId));

        return typeRepository.findByCategory(category);
    }
}
