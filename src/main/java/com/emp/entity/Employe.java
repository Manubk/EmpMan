package com.emp.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.cglib.core.Local;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employe {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID")
	@Id
	private Long empId;
	
	@Column(name = "EMP_NAME")
	private String empName;

	@Column(name = "EMP_EMAIL")
	private String empEmail;
	
	@Column(name = "EMP_PASS")
	private String empPass;
	
	@Column(name = "EMP_ROLE")
	private String empRole;
	
	@CreationTimestamp
	@Column(name = "CREATED_AT" , updatable = false)
	private LocalDate createdAt;
	
	@UpdateTimestamp
	@Column(name = "UPDATED_AT" , insertable = false)
	private LocalDate updatedAt;
	

}
