package com.springboot.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.test.model.Unit;
import com.springboot.test.service.UnitService;

@RestController
@RequestMapping("/unit")
public class UnitController {

	@Autowired
	UnitService unitService;
	
	@GetMapping("")
	public ResponseEntity<Unit> getUnit(String name) {
		Unit unit = unitService.getUnit(name).orElse(new Unit());
		
		return ResponseEntity.ok(unit);
	}
}
