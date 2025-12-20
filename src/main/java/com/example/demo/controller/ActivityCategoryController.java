package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ActivityCategoryEntity;
import com.example.demo.service.ActivityCategoryService;

@RestController
@RequestMapping("/api/categories")
public class ActivityCategoryController {

    private final ActivityCategoryService service;

    public ActivityCategoryController(ActivityCategoryService service) {
        this.service = service;
    }

    // POST /api/categories
    @PostMapping
    public ActivityCategoryEntity createCategory(
            @RequestBody ActivityCategoryEntity category) {
        return service.createCategory(category);
    }

    // GET /api/categories
    @GetMapping
    public List<ActivityCategoryEntity> getAllCategories() {
        return service.getAllCategories();
    }

    // GET /api/categories/{id}
    @GetMapping("/{id}")
    public ActivityCategoryEntity getCategory(@PathVariable Long id) {
        return service.getCategory(id);
    }
}
