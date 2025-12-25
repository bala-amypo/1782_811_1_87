package com.example.demo.service.impl;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmissionFactorRepository;
import com.example.demo.service.interfaces.EmissionFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmissionFactorServiceImpl implements EmissionFactorService {

    @Autowired
    private EmissionFactorRepository emissionFactorRepository;

    @Override
    public EmissionFactor save(EmissionFactor emissionFactor) {
        return emissionFactorRepository.save(emissionFactor);
    }

    @Override
    public Optional<EmissionFactor> findById(Long id) {
        return emissionFactorRepository.findById(id);
    }

    @Override
    public Optional<EmissionFactor> findByActivityTypeId(Long activityTypeId) {
        return emissionFactorRepository.findByActivityTypeId(activityTypeId);
    }

    @Override
    public List<EmissionFactor> findAll() {
        return emissionFactorRepository.findAll();
    }

    @Override
    public EmissionFactor update(Long id, EmissionFactor updatedFactor) {
        EmissionFactor emissionFactor = emissionFactorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Emission factor not found with id: " + id));
        
        if (updatedFactor.getActivityType() != null) {
            emissionFactor.setActivityType(updatedFactor.getActivityType());
        }
        if (updatedFactor.getFactorValue() != null) {
            emissionFactor.setFactorValue(updatedFactor.getFactorValue());
        }
        if (updatedFactor.getUnit() != null) {
            emissionFactor.setUnit(updatedFactor.getUnit());
        }
        
        return emissionFactorRepository.save(emissionFactor);
    }

    @Override
    public void deleteById(Long id) {
        if (!emissionFactorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Emission factor not found with id: " + id);
        }
        emissionFactorRepository.deleteById(id);
    }
}