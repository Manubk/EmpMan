package com.emp.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.emp.constants.AppConstants;
import com.emp.dto.EmpSignUpDto;
import com.emp.dto.LoginResponseDto;
import com.emp.dto.loginDto;
import com.emp.entity.Employe;
import com.emp.entity.User;
import com.emp.exception.DataNotFoundException;
import com.emp.repo.EmpRepo;
import com.emp.repo.UserRepo;
import com.emp.serviceinterfaces.ISecurityService;

@Service
public class SecurityService  implements  UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;
	
	//	Here we used email as the userName
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByUsername(userName);
		
		if(user.isEmpty())
			throw new DataNotFoundException("User Not Found :(");
		
		return user.get();
	}
	
	
	/*
	 * @Override public LoginResponseDto login(loginDto login) {
	 * 
	 * LoginResponseDto res = new LoginResponseDto(); Employe emp =
	 * empRepo.findByEmpEmail(login.getEmail());
	 * 
	 * //If the entred email is alread present if(emp == null ) {
	 * res.setAllowed(false); res.setReason(AppConstants.EMAIL_NOTPRESENT); return
	 * res; }
	 * 
	 * if(emp.getEmpPass().equals(login.getPass())) { res.setAllowed(true);
	 * res.setReason(AppConstants.LOGIN_SUCCESS); res.setRole(emp.getEmpRole());
	 * 
	 * return res; }
	 * 
	 * //if password is wrong res.setReason(AppConstants.BAD_CREDENCIALS); return
	 * res; }
	 * 
	 * @Override public LoginResponseDto signUp(EmpSignUpDto empDto) {
	 * 
	 * LoginResponseDto res = new LoginResponseDto(); Employe emp =
	 * empRepo.findByEmpEmail(empDto.getEmpEmail());
	 * 
	 * //If email in Not Present if(emp == null) { emp = new Employe();
	 * BeanUtils.copyProperties(empDto, emp); empRepo.save(emp);
	 * 
	 * res.setAllowed(false); res.setReason(AppConstants.SIGNUP_SUCCESS); return
	 * res; }else { res.setReason(AppConstants.EMAIL_PRESENT);
	 * res.setAllowed(false); return res; }
	 * 
	 * 
	 * }
	 */
	
	
	
}
