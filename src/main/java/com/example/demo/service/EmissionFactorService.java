package com.example.demo.service;

import com.example.demo.entity.EmissionFactor;
import java.util.List;
import java.util.Optional;

public interface EmissionFactorService {
    EmissionFactor save(EmissionFactor emissionFactor);
    Optional<EmissionFactor> findById(Long id);
    Optional<EmissionFactor> findByActivityTypeId(Long activityTypeId);
    List<EmissionFactor> findAll();
    EmissionFactor update(Long id, EmissionFactor emissionFactor);
    void deleteById(Long id);
}