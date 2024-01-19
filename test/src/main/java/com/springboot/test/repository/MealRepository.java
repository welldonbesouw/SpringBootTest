package com.springboot.test.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.test.model.Meal;

public interface MealRepository extends JpaRepository<Meal, UUID>{

	Page<Meal> findByNameContainingIgnoreCase(String keyword, Pageable pageable);

}
