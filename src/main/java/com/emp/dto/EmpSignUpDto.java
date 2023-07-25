package com.emp.dto;

import lombok.Data;

@Data
public class EmpSignUpDto {
	
	private Long empId;
	
	private String empName;
	
	private String empEmail;
	
	private String empPass;
	
	private String empRole;
}
