package com.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.constants.AppConstants;
import com.emp.dto.EmpSignUpDto;
import com.emp.dto.LoginResponseDto;
import com.emp.dto.loginDto;
import com.emp.serviceinterfaces.ISecurityService;

@CrossOrigin
@RestController
public class SecurityController {
	
	@Autowired
	private ISecurityService securityService;
	
	@PostMapping("/login")
	private ResponseEntity<LoginResponseDto> login(@RequestBody loginDto loginDto){
		
		LoginResponseDto login = securityService.login(loginDto);
		
		return (login.getReason().equals(AppConstants.LOGIN_SUCCESS))?
				new ResponseEntity<LoginResponseDto>(login,HttpStatus.ACCEPTED):
					new ResponseEntity<LoginResponseDto>(login,HttpStatus.NOT_ACCEPTABLE);
	} 
	
	
	@PostMapping("/singup")
	private ResponseEntity<String> singUp(@RequestBody EmpSignUpDto empDto){
		
		boolean signUp = securityService.signUp(empDto);
		
		return (signUp)?new ResponseEntity<String>("Sign Up SuccessFull",HttpStatus.OK):
			new ResponseEntity<String>("SignUp Failes",HttpStatus.BAD_REQUEST);
		
	}
}
