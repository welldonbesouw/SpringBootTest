package com.springboot.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.test.model.Ingredient;
import com.springboot.test.repository.IngredientRepository;

@Service
public class IngredientService {
	
	@Autowired
	IngredientRepository ingredientRepo;

	public Ingredient register(Ingredient request) {
		Ingredient ingredient = new Ingredient();
		ingredient.setName(request.getName());
		ingredient.setAmount(request.getAmount());
		ingredient.setUnit(request.getUnit());
		
		return ingredientRepo.save(ingredient);
	}
}
