package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.EmissionFactor;

public interface EmissionFactorService {

    EmissionFactor createFactor(Long activityTypeId, EmissionFactor factor);

    EmissionFactor getFactorById(Long id);

    List<EmissionFactor> getFactorsByActivityType(Long activityTypeId);

    List<EmissionFactor> getAllFactors();
}
