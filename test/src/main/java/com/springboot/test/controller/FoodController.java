package com.springboot.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.test.model.Ingredient;
import com.springboot.test.model.Meal;
import com.springboot.test.payload.request.FoodRequest;
import com.springboot.test.service.IngredientService;
import com.springboot.test.service.MealService;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

	
	@Autowired
	MealService mealService;
	
	@Autowired
	IngredientService ingredientService;
	
	@PostMapping("")
	public ResponseEntity<Meal> registerFood(@RequestBody Meal foodRequest) {
		List<Ingredient> ingredients = foodRequest.getIngredients();
		List<Long> ingredientIds = new ArrayList<>();
		for(Ingredient item : ingredients) {
			Ingredient savedIng = ingredientService.register(item);
			ingredientIds.add(savedIng.getId());
		}
		
		Meal mealRequest = new Meal();
		mealRequest.setName(foodRequest.getName());
		mealRequest.setArea(foodRequest.getArea());
		mealRequest.setDescriptions(foodRequest.getDescriptions());
		mealRequest.setTutorialLink(foodRequest.getTutorialLink());
		Meal meal = mealService.register(mealRequest, ingredientIds);
		
		return ResponseEntity.ok(meal);
	}
	
	@GetMapping("")
	public ResponseEntity<Page<Meal>> getFood(@RequestParam String keyword,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "9") int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Meal> meals;
		
		if(keyword != null && !keyword.isEmpty()) {
			meals = mealService.searchMeal(keyword, pageable);
		} else {
			meals = mealService.getAllMeals(pageable);
		}
		
		return ResponseEntity.ok(meals);
		
	}
	
	@DeleteMapping("{id}")
	public void deleteFood(@PathVariable UUID id) {
		mealService.delete(id);
	}
	
	@PatchMapping("{id}")
	public ResponseEntity<Meal> updateFood(@PathVariable UUID id, @RequestBody FoodRequest foodRequest) {
		Meal previousMeal = mealService.getById(id);
		Meal updatedMeal = mealService.update(id,foodRequest);
		List<String> response = new ArrayList<>();
		if(!previousMeal.getName().equals(updatedMeal.getName())) response.add(updatedMeal.getName());
		if(!previousMeal.getTutorialLink().equals(updatedMeal.getTutorialLink())) response.add(updatedMeal.getTutorialLink());
		if(!previousMeal.getArea().equals(updatedMeal.getArea())) response.add(updatedMeal.getArea());
		List<Ingredient> prevIng = previousMeal.getIngredients();
		List<Ingredient> updtIng = updatedMeal.getIngredients();
		
		return ResponseEntity.ok(updatedMeal);
	}
}
