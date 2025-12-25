package com.example.demo.controller;

import com.example.demo.entity.EmissionFactor;
import com.example.demo.service.EmissionFactorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emission-factors")
public class EmissionFactorController {

    @Autowired
    private EmissionFactorService emissionFactorService;

    @PostMapping
    public ResponseEntity<EmissionFactor> createEmissionFactor(@RequestBody EmissionFactor emissionFactor) {
        return ResponseEntity.ok(emissionFactorService.save(emissionFactor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmissionFactor> getEmissionFactor(@PathVariable Long id) {
        return emissionFactorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmissionFactor>> getAllEmissionFactors() {
        return ResponseEntity.ok(emissionFactorService.findAll());
    }

    @GetMapping("/activity-type/{activityTypeId}")
    public ResponseEntity<EmissionFactor> getEmissionFactorByActivityType(@PathVariable Long activityTypeId) {
        return emissionFactorService.findByActivityTypeId(activityTypeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmissionFactor> updateEmissionFactor(@PathVariable Long id, @RequestBody EmissionFactor emissionFactor) {
        return ResponseEntity.ok(emissionFactorService.update(id, emissionFactor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmissionFactor(@PathVariable Long id) {
        emissionFactorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}