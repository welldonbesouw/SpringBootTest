package com.springboot.test.payload.request;

import java.util.ArrayList;
import java.util.List;

import com.springboot.test.model.Ingredient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class FoodRequest {

	@NotBlank
	private String name;
	@NotBlank
	private String tutorialLink;
	private String area;
	private String descriptions;
	@NotEmpty
	private List<Ingredient> ingredients = new ArrayList<>();
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTutorialLink() {
		return tutorialLink;
	}
	public void setTutorialLink(String tutorialLink) {
		this.tutorialLink = tutorialLink;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	
}
