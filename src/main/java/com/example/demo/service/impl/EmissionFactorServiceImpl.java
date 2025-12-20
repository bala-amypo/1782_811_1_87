package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmissionFactorEntity;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.EmissionFactorService;

@Service
public class EmissionFactorServiceImpl implements EmissionFactorService {

    @Autowired
    private EmissionFactorRepository repository;

    @Override
    public EmissionFactorEntity createFactor(Long activityTypeId, EmissionFactorEntity factor) {
        factor.setActivityTypeId(activityTypeId);
        return repository.save(factor);
    }

    @Override
    public EmissionFactorEntity getFactorById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<EmissionFactorEntity> getFactorsByActivityType(Long activityTypeId) {
        return repository.findByActivityTypeId(activityTypeId);
    }

    @Override
    public List<EmissionFactorEntity> getAllFactors() {
        return repository.findAll();
    }
}
