package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ActivityTypeEntity;
import com.example.demo.service.ActivityTypeService;

@RestController
@RequestMapping("/api/types")
public class ActivityTypeController {

    private final ActivityTypeService service;

    public ActivityTypeController(ActivityTypeService service) {
        this.service = service;
    }

    // POST /api/types/category/{categoryId}
    @PostMapping("/a/{categoryId}")
    public ActivityTypeEntity createType(
            @PathVariable Long categoryId,
            @RequestBody ActivityTypeEntity type) {
        return service.createType(categoryId, type);
    }

    // GET /api/types/category/{categoryId}
    @GetMapping("/b/{categoryId}")
    public List<ActivityTypeEntity> getTypesByCategory(
            @PathVariable Long categoryId) {
        return service.getTypesByCategory(categoryId);
    }

    // GET /api/types/{id}
    @GetMapping("/c/{id}")
    public ActivityTypeEntity getType(@PathVariable Long id) {
        return service.getType(id);
    }
}
