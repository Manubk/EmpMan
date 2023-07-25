package com.emp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dto.EmpSignUpDto;
import com.emp.entity.Employe;
import com.emp.repo.EmpRepo;
import com.emp.serviceinterfaces.IEmpService;

@Service
public class EmpService implements IEmpService {
	
	
	@Autowired
	private EmpRepo empRepo;

	@Override
	public List<EmpSignUpDto> findAllEmp() {
		
		List<Employe> allEmp = empRepo.findAll();
		
		List<EmpSignUpDto> empDtoList = new ArrayList();
		
		for(Employe emp : allEmp ) {
			EmpSignUpDto empDto = new EmpSignUpDto();
			
			BeanUtils.copyProperties(emp, empDto);
			
			empDtoList.add(empDto);
		}
		return empDtoList;
	}

	@Override
	public List<EmpSignUpDto> deleteEmp(Long empId) {
		
		if(empRepo.existsById(empId)) {
			empRepo.deleteById(empId);
		}
		return findAllEmp();
	}

	@Override
	public List<EmpSignUpDto> addEmp(EmpSignUpDto empDto) {
		
		if(empDto.getEmpId()==0 && empRepo.findByEmpEmail(empDto.getEmpEmail()) == null) {
			Employe emp = new Employe();
			
			BeanUtils.copyProperties(empDto, emp);
			
			empRepo.save(emp);
			
		}
	
		return findAllEmp();
	}

	@Override
	public List<EmpSignUpDto> updateEmp(EmpSignUpDto empDto) {
		
		if(empDto.getEmpId() != 0) {
			Employe emp = new Employe();
			BeanUtils.copyProperties(empDto, emp);
			empRepo.save(emp);
		}
		
		return findAllEmp();
	}
	
	
	
}
