package com.springboot.test.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.test.model.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long> {
	Optional<Unit> getByName(String name);
}
