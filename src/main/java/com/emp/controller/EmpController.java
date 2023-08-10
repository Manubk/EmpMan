package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.emp.dto.EmpSignUpDto;
import com.emp.serviceinterfaces.IEmpService;

@CrossOrigin
@RestController
public class EmpController {
	
	@Autowired
	private IEmpService empService;
	
	@GetMapping("/")
	private String home() {
		return "Home";
	}
	
	/*
	 * This Should Check First is Email is Already Present 
	 * If it is present then Exception should be sent to client
	 *  If Not Then save the Details It Also
	 * Validates the Inputs
	 */
	
	@PostMapping("/emp")
	private ResponseEntity<List<EmpSignUpDto>> addEmp(@RequestBody EmpSignUpDto empDto){
		
		List<EmpSignUpDto> emps = empService.addEmp(empDto);
		
		return new ResponseEntity<List<EmpSignUpDto>>(emps,HttpStatus.OK);
	}	
	
	/*
	 * Email Cannot Be Edited 
	 * Validate all the fields
	 */
	
	@PutMapping("/emp")
	private ResponseEntity<List<EmpSignUpDto>> updateEmp(@RequestBody EmpSignUpDto empDto){
		
		List<EmpSignUpDto> emps = empService.updateEmp(empDto);
		
		return new ResponseEntity<List<EmpSignUpDto>>(emps,HttpStatus.OK);
	}	
	

	@GetMapping("/emps")
	private ResponseEntity<List<EmpSignUpDto>> getAllEmp(){
		
		List<EmpSignUpDto> emps = empService.findAllEmp();
		
		return new ResponseEntity<List<EmpSignUpDto>>(emps,HttpStatus.OK);
	}
	
	@GetMapping("/empss")
	private ResponseEntity<List<EmpSignUpDto>> getAllEmpByPage( 
			@RequestParam(value = "pageNumber",defaultValue = "1",required = false) Integer pageNumber ,
			@RequestParam(value = "pageSize",defaultValue = "5",required = false) Integer pageSize){
		
		List<EmpSignUpDto> emps = empService.findAllEmp(pageNumber,pageSize);
		
		return new ResponseEntity<List<EmpSignUpDto>>(emps,HttpStatus.OK);
	}

	
//	@GetMapping("/addemp/{num}")
//	private ResponseEntity<String> addRecords(@PathVariable Integer num ){
//		
//		empService.add10Emps(num);
//	
//	}
	
	
	
	@DeleteMapping("/emp/{empId}")
	private ResponseEntity<List<EmpSignUpDto>> DeleteEmp(@PathVariable Long empId){
		
		List<EmpSignUpDto> emps = empService.deleteEmp(empId);
		
		return new ResponseEntity<List<EmpSignUpDto>>(emps,HttpStatus.OK);
	}
	
}
