package com.springboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.test.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
