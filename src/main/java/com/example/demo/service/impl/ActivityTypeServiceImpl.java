package com.example.demo.service.impl;

import com.example.demo.entity.ActivityType;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ActivityTypeRepository;
import com.example.demo.service.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService {

    @Autowired
    private ActivityTypeRepository activityTypeRepository;

    @Override
    public ActivityType save(ActivityType activityType) {
        return activityTypeRepository.save(activityType);
    }

    @Override
    public Optional<ActivityType> findById(Long id) {
        return activityTypeRepository.findById(id);
    }

    @Override
    public List<ActivityType> findAll() {
        return activityTypeRepository.findAll();
    }

    @Override
    public List<ActivityType> findByCategoryId(Long categoryId) {
        return activityTypeRepository.findByCategoryId(categoryId);
    }

    @Override
    public ActivityType update(Long id, ActivityType updatedType) {
        ActivityType activityType = activityTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity type not found with id: " + id));
        
        if (updatedType.getTypeName() != null) {
            activityType.setTypeName(updatedType.getTypeName());
        }
        if (updatedType.getCategory() != null) {
            activityType.setCategory(updatedType.getCategory());
        }
        if (updatedType.getUnit() != null) {
            activityType.setUnit(updatedType.getUnit());
        }
        
        return activityTypeRepository.save(activityType);
    }

    @Override
    public void deleteById(Long id) {
        if (!activityTypeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Activity type not found with id: " + id);
        }
        activityTypeRepository.deleteById(id);
    }
}