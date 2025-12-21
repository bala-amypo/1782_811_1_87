package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;

@RestController
@RequestMapping("/api/types")
public class ActivityTypeController {

    private final ActivityTypeService service;

    public ActivityTypeController(ActivityTypeService service) {
        this.service = service;
    }
    @PostMapping("/category/{categoryId}")
    public ActivityType createType(
            @PathVariable Long categoryId,
            @RequestBody ActivityType type) {
        return service.createType(categoryId, type);
    }

    @GetMapping("/category/{categoryId}")
    public List<ActivityType> getTypesByCategory(@PathVariable Long categoryId) {
        return service.getTypesByCategory(categoryId);
    }

    @GetMapping("/{id}")
    public ActivityType getType(@PathVariable Long id) {
        return service.getType(id);
    }
}
