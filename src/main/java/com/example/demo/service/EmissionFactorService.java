package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EmissionFactorEntity;

public interface EmissionFactorService {

    EmissionFactorEntity createFactor(Long activityTypeId, EmissionFactorEntity factor);

    EmissionFactorEntity getFactorById(Long id);

    List<EmissionFactorEntity> getFactorsByActivityType(Long activityTypeId);

    List<EmissionFactorEntity> getAllFactors();
}
