package com.springboot.test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.test.model.ERole;
import com.springboot.test.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByName(ERole roleUser);

}
