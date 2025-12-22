package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ActivityCategory;
import com.example.demo.entity.ActivityType;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {

    Optional<ActivityType> findByTypeName(String typeName);
    List<ActivityType> findByCategory(ActivityCategory category);
}
