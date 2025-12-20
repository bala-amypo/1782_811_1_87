package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.EmissionFactorService;

@Service
public class EmissionFactorServiceImpl implements EmissionFactorService {

    @Autowired
    private EmissionFactorRepository repository;

    @Override
    public EmissionFactor createFactor(Long activityTypeId, EmissionFactor factor) {
        factor.setActivityTypeId(activityTypeId);
        return repository.save(factor);
    }

    @Override
    public EmissionFactor getFactorById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<EmissionFactor> getFactorsByActivityType(Long activityTypeId) {
        return repository.findByActivityTypeId(activityTypeId);
    }

    @Override
    public List<EmissionFactor> getAllFactors() {
        return repository.findAll();
    }
}
