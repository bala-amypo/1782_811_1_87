package com.example.demo.controller;

import com.example.demo.entity.ActivityType;
import com.example.demo.service.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-types")
public class ActivityTypeController {

    @Autowired
    private ActivityTypeService activityTypeService;

    @PostMapping
    public ResponseEntity<ActivityType> createActivityType(@RequestBody ActivityType activityType) {
        return ResponseEntity.ok(activityTypeService.save(activityType));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityType> getActivityType(@PathVariable Long id) {
        return activityTypeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ActivityType>> getAllActivityTypes() {
        return ResponseEntity.ok(activityTypeService.findAll());
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ActivityType>> getActivityTypesByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(activityTypeService.findByCategoryId(categoryId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityType> updateActivityType(@PathVariable Long id, @RequestBody ActivityType activityType) {
        return ResponseEntity.ok(activityTypeService.update(id, activityType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActivityType(@PathVariable Long id) {
        activityTypeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}