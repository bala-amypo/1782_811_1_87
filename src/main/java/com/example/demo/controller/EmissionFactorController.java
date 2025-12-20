package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EmissionFactorEntity;
import com.example.demo.service.EmissionFactorService;

@RestController
@RequestMapping("/api/factors")
public class EmissionFactorController {

    @Autowired
    private EmissionFactorService service;

    // POST /api/factors/{activityTypeId}
    @PostMapping("/{activityTypeId}")
    public EmissionFactorEntity createFactor(
            @PathVariable Long activityTypeId,
            @RequestBody EmissionFactorEntity factor) {

        return service.createFactor(activityTypeId, factor);
    }

    // GET /api/factors/{id}
    @GetMapping("/{id}")
    public EmissionFactorEntity getFactorById(@PathVariable Long id) {
        return service.getFactorById(id);
    }

    // GET /api/factors/type/{activityTypeId}
    @GetMapping("/type/{activityTypeId}")
    public List<EmissionFactorEntity> getFactorsByType(@PathVariable Long activityTypeId) {
        return service.getFactorsByActivityType(activityTypeId);
    }

    // GET /api/factors
    @GetMapping
    public List<EmissionFactorEntity> getAllFactors() {
        return service.getAllFactors();
    }
}
