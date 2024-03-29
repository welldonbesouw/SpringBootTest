package com.springboot.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.test.payload.response.MealResponse;
import com.springboot.test.repository.MealResponseRepository;

@Service
public class MealResponseService {

	@Autowired
	MealResponseRepository mealResponseRepo;
	
	public MealResponse getByCode(int code) {
		MealResponse response = mealResponseRepo.findByErrorCode(code);
		return response;
	}

}
