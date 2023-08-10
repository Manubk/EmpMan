package com.emp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.emp.entity.Employe;

@Repository
public interface EmpRepo extends JpaRepository<Employe, Long> {
	
	Optional<User> findByEmpEmail(String empEmail);
	
	
}
