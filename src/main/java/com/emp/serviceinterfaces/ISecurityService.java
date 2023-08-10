package com.emp.serviceinterfaces;

import com.emp.dto.EmpSignUpDto;
import com.emp.dto.LoginResponseDto;
import com.emp.dto.loginDto;

public interface ISecurityService {
	
	public LoginResponseDto login(loginDto login);
	
	public LoginResponseDto signUp(EmpSignUpDto empDto);
	
	
}
