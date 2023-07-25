package com.emp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.constants.AppConstants;
import com.emp.dto.EmpSignUpDto;
import com.emp.dto.LoginResponseDto;
import com.emp.dto.loginDto;
import com.emp.entity.Employe;
import com.emp.repo.EmpRepo;
import com.emp.serviceinterfaces.ISecurityService;

@Service
public class SecurityService  implements ISecurityService{
	
	@Autowired
	private EmpRepo empRepo;
	
	
	@Override
	public LoginResponseDto login(loginDto login) {
	
	LoginResponseDto res = new LoginResponseDto();
	Employe emp = empRepo.findByEmpEmail(login.getEmail());
	
	if(emp == null ) {
		res.setReason(AppConstants.BAD_CREDENCIALS);
		
		return res;
	}
	
	if(emp.getEmpPass().equals(login.getPass())) {
		res.setAllowed(true);
		res.setReason(AppConstants.LOGIN_SUCCESS);
		res.setRole(emp.getEmpRole());
		
		return res;
	}	
		
		
		return res;
	}

	@Override
	public boolean signUp(EmpSignUpDto empDto) {
		
		Employe emp = empRepo.findByEmpEmail(empDto.getEmpEmail());
		
//		If the Email is  not present then user are allowed to sign up 
		
		if(emp == null) {
			emp = new Employe();
			
			BeanUtils.copyProperties(empDto, emp);
			
			empRepo.save(emp);
			
			return true;
		}
		
		return false;
	}
	
	
	
}
