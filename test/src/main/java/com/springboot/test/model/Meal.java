package com.springboot.test.model;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name = "meals")
@SQLDelete(sql = "UPDATE meals SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Meal {

	@Id
	@UuidGenerator(style = UuidGenerator.Style.TIME)
	private UUID id;
	@NotBlank
	private String name;
	@NotBlank
	private String tutorialLink;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "meal_ingredient",
			joinColumns = @JoinColumn(name = "meals_id"),
			inverseJoinColumns = @JoinColumn(name = "ingredients_id"))
	private List<Ingredient> ingredients = new ArrayList<>();
	
	private String area;
	@Column(columnDefinition = "TEXT")
	private String descriptions;
	private boolean deleted = Boolean.FALSE;
	
	public Meal() {
		
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
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
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
}
