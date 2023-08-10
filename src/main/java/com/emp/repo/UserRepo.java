package com.emp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String userName);
	
}
