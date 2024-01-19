package com.springboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.test.payload.response.MealResponse;

public interface MealResponseRepository extends JpaRepository<MealResponse, Long> {

	MealResponse findByErrorCode(int code);

}
