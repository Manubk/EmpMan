package com.emp.dto;

import lombok.Data;

@Data
public class LoginResponseDto {
	
	private boolean allowed;
	
	private String role;
	
	private String reason ;
}
