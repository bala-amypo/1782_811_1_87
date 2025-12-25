package com.example.demo.controller;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.service.ActivityCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-categories")
public class ActivityCategoryController {

    @Autowired
    private ActivityCategoryService activityCategoryService;

    @PostMapping
    public ResponseEntity<ActivityCategory> createActivityCategory(@RequestBody ActivityCategory activityCategory) {
        return ResponseEntity.ok(activityCategoryService.save(activityCategory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityCategory> getActivityCategory(@PathVariable Long id) {
        return activityCategoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ActivityCategory>> getAllActivityCategories() {
        return ResponseEntity.ok(activityCategoryService.findAll());
    }

    @GetMapping("/name/{categoryName}")
    public ResponseEntity<ActivityCategory> getActivityCategoryByName(@PathVariable String categoryName) {
        return activityCategoryService.findByCategoryName(categoryName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityCategory> updateActivityCategory(@PathVariable Long id, @RequestBody ActivityCategory activityCategory) {
        return ResponseEntity.ok(activityCategoryService.update(id, activityCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivityCategory(@PathVariable Long id) {
        activityCategoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/exists/{categoryName}")
    public ResponseEntity<Boolean> existsByCategoryName(@PathVariable String categoryName) {
        return ResponseEntity.ok(activityCategoryService.existsByCategoryName(categoryName));
    }
}