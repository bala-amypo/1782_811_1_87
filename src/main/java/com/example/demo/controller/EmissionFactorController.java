package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;

@RestController
@RequestMapping("/api/factors")
public class EmissionFactorController {

    @Autowired
    private EmissionFactorService service;

    // POST /api/factors/{activityTypeId}
    @PostMapping("/{activityTypeId}")
    public EmissionFactor createFactor(
            @PathVariable Long activityTypeId,
            @RequestBody EmissionFactor factor) {

        return service.createFactor(activityTypeId, factor);
    }

    // GET /api/factors/{id}
    @GetMapping("/{id}")
    public EmissionFactor getFactorById(@PathVariable Long id) {
        return service.getFactorById(id);
    }

    // GET /api/factors/type/{activityTypeId}
    @GetMapping("/type/{activityTypeId}")
    public List<EmissionFactor> getFactorsByType(@PathVariable Long activityTypeId) {
        return service.getFactorsByActivityType(activityTypeId);
    }

    // GET /api/factors
    @GetMapping
    public List<EmissionFactor> getAllFactors() {
        return service.getAllFactors();
    }
}
