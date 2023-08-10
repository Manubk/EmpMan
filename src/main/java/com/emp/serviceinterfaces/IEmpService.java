package com.emp.serviceinterfaces;

import java.util.List;

import com.emp.dto.EmpSignUpDto;

public interface IEmpService {
	
	public List<EmpSignUpDto> findAllEmp();
	
	public String add10Emps(Integer num);
	
	public List<EmpSignUpDto> findAllEmp(Integer pageNumber , Integer pageSize);
	
	public List<EmpSignUpDto> deleteEmp(Long empId);
	
	public List<EmpSignUpDto> addEmp(EmpSignUpDto empDto);
	
	public List<EmpSignUpDto> updateEmp(EmpSignUpDto empDto);
}
