package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ActivityCategoryEntity;

public interface ActivityCategoryRepository
        extends JpaRepository<ActivityCategoryEntity, Long> {

    Optional<ActivityCategoryEntity> findByCategoryName(String categoryName);
}
