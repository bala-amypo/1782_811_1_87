package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ActivityCategory;
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
    public ActivityCategory createCategory(@RequestBody ActivityCategory category) {
        return service.createCategory(category);
    }

    // GET /api/categories
    @GetMapping
    public List<ActivityCategory> getAllCategories() {
        return service.getAllCategories();
    }

    // GET /api/categories/{id}
    @GetMapping("/{id}")
    public ActivityCategory getCategory(@PathVariable Long id) {
        return service.getCategory(id);
    }
}
