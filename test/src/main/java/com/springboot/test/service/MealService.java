package com.springboot.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.test.model.Ingredient;
import com.springboot.test.model.Meal;
import com.springboot.test.payload.request.FoodRequest;
import com.springboot.test.repository.IngredientRepository;
import com.springboot.test.repository.MealRepository;

@Service
public class MealService {
	@Autowired
	MealRepository mealRepo;
	
	@Autowired
	IngredientRepository ingredientRepo;
	
	public Meal register(Meal foodRequest, List<Long> ingredientIds) {
		Meal meal = new Meal();
		meal.setName(foodRequest.getName());
		meal.setArea(foodRequest.getArea());
		meal.setDescriptions(foodRequest.getDescriptions());
		meal.setTutorialLink(foodRequest.getTutorialLink());
		
		List<Ingredient> ingredients = new ArrayList<>();
		for(Long item : ingredientIds) {
			ingredients.add(ingredientRepo.getReferenceById(item));
		}
		
		meal.setIngredients(ingredients);
		
		return mealRepo.save(meal);
	}

	public Page<Meal> searchMeal(String keyword, Pageable pageable) {
		Page<Meal> meals = mealRepo.findByNameContainingIgnoreCase(keyword, pageable);
		
		return meals;
	}
	
	public Page<Meal> getAllMeals(Pageable pageable) {
		return mealRepo.findAll(pageable);
	}

	public void delete(UUID id) {
		mealRepo.deleteById(id);
	}

	public Meal update(UUID id, FoodRequest foodRequest) {
		Meal meal = mealRepo.findById(id).get();
		
		if(foodRequest.getName() != null) meal.setName(foodRequest.getName());
		if(foodRequest.getArea() != null) meal.setArea(foodRequest.getArea());
		if(foodRequest.getDescriptions() != null) meal.setArea(foodRequest.getDescriptions());
		if(foodRequest.getTutorialLink() != null) meal.setTutorialLink(foodRequest.getTutorialLink());
		if(foodRequest.getIngredients().size() != 0) meal.setIngredients(foodRequest.getIngredients());
		
		return meal;
	}
	
	public Meal getById(UUID id) {
		return mealRepo.findById(id).get();
	}
}
