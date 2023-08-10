package com.emp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emp.constants.AppConstants;
import com.emp.dto.EmpSignUpDto;
import com.emp.entity.Employe;
import com.emp.exception.AlreadyPresentException;
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
	public List<EmpSignUpDto> findAllEmp(Integer pageNumber ,Integer pageSize) {
		
		Pageable page = PageRequest.of(pageNumber, pageSize);
		
		Page<Employe> findAll = empRepo.findAll(page);
		
		List<Employe> allEmp = findAll.getContent();
		
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
		
		if(empRepo.findByEmpEmail(empDto.getEmpEmail()) != null)
			throw new AlreadyPresentException(AppConstants.EMAIL_PRESENT);
		
		if((empDto.getEmpId()==null || empDto.getEmpId()==0)) {
			
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

	@Override
	public String add10Emps(Integer num) {
		
		Employe emp =  null;
		
		for(int i = 0; i<num; i++) {
			emp = new Employe();
			emp.setEmpEmail("emp"+i+"@gmail.com");
			emp.setEmpName("manu"+i);
			emp.setEmpPass("123"+i);
			
			if(i%2==0)
				emp.setEmpRole("admin");
			else
				emp.setEmpRole("user");
			
			empRepo.save(emp);
		}
		return null;
	}
	
	
	
}
