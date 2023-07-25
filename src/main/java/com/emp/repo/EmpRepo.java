package com.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emp.entity.Employe;

@Repository
public interface EmpRepo extends JpaRepository<Employe, Long> {
	
	public Employe findByEmpEmail(String empEmail);
}
