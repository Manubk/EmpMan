package com.emp.serviceinterfaces;

import java.util.List;

import com.emp.dto.EmpSignUpDto;

public interface IEmpService {
	
	public List<EmpSignUpDto> findAllEmp();
	
	public List<EmpSignUpDto> deleteEmp(Long empId);
	
	public List<EmpSignUpDto> addEmp(EmpSignUpDto empDto);
	
	public List<EmpSignUpDto> updateEmp(EmpSignUpDto empDto);
}
