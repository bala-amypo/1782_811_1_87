package com.example.demo.service.impl;

import com.example.demo.dto.ActivityLogRequest;
import com.example.demo.entity.ActivityLog;
import com.example.demo.entity.ActivityType;
import com.example.demo.entity.EmissionFactor;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ActivityLogRepository;
import com.example.demo.service.interfaces.ActivityLogService;
import com.example.demo.service.interfaces.ActivityTypeService;
import com.example.demo.service.interfaces.EmissionFactorService;
import com.example.demo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    @Autowired
    private ActivityLogRepository activityLogRepository;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ActivityTypeService activityTypeService;
    
    @Autowired
    private EmissionFactorService emissionFactorService;

    @Override
    public ActivityLog save(ActivityLogRequest request) {
        User user = userService.findById(request.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + request.getUserId()));
        
        ActivityType activityType = activityTypeService.findById(request.getActivityTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("Activity type not found with id: " + request.getActivityTypeId()));
        
        ActivityLog activityLog = new ActivityLog();
        activityLog.setUser(user);
        activityLog.setActivityType(activityType);
        activityLog.setQuantity(request.getQuantity());
        activityLog.setActivityDate(request.getActivityDate());
        
        // Calculate estimated emission
        Optional<EmissionFactor> emissionFactor = emissionFactorService.findByActivityTypeId(request.getActivityTypeId());
        if (emissionFactor.isPresent()) {
            double emission = request.getQuantity() * emissionFactor.get().getFactorValue();
            activityLog.setEstimatedEmission(emission);
        }
        
        return activityLogRepository.save(activityLog);
    }

    @Override
    public Optional<ActivityLog> findById(Long id) {
        return activityLogRepository.findById(id);
    }

    @Override
    public List<ActivityLog> findAll() {
        return activityLogRepository.findAll();
    }

    @Override
    public List<ActivityLog> findByUserId(Long userId) {
        return activityLogRepository.findByUserId(userId);
    }

    @Override
    public List<ActivityLog> findByUserIdAndDateRange(Long userId, LocalDate startDate, LocalDate endDate) {
        return activityLogRepository.findByUserIdAndActivityDateBetween(userId, startDate, endDate);
    }

    @Override
    public ActivityLog update(Long id, ActivityLogRequest request) {
        ActivityLog activityLog = activityLogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity log not found with id: " + id));
        
        if (request.getQuantity() != null) {
            activityLog.setQuantity(request.getQuantity());
        }
        if (request.getActivityDate() != null) {
            activityLog.setActivityDate(request.getActivityDate());
        }
        
        // Recalculate emission if quantity changed
        if (request.getQuantity() != null) {
            Optional<EmissionFactor> emissionFactor = emissionFactorService.findByActivityTypeId(activityLog.getActivityType().getId());
            if (emissionFactor.isPresent()) {
                double emission = activityLog.getQuantity() * emissionFactor.get().getFactorValue();
                activityLog.setEstimatedEmission(emission);
            }
        }
        
        return activityLogRepository.save(activityLog);
    }

    @Override
    public void deleteById(Long id) {
        if (!activityLogRepository.existsById(id)) {
            throw new ResourceNotFoundException("Activity log not found with id: " + id);
        }
        activityLogRepository.deleteById(id);
    }

    @Override
    public Double calculateTotalEmissionsByUser(Long userId) {
        return activityLogRepository.sumEstimatedEmissionsByUserId(userId);
    }
}