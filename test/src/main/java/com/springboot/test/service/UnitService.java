package com.springboot.test.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.test.model.Unit;

@Service
public class UnitService {

	@Autowired
	UnitRepository unitRepo;
	
	public Optional<Unit> getUnit(String name) {
		Optional<Unit> unit = unitRepo.getByName(name);
		return unit;
	}

}
