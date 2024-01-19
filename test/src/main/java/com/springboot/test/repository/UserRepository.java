package com.springboot.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.test.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String email);

	boolean existsByEmail(String username);

}
