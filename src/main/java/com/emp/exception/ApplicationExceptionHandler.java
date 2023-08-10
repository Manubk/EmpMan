package com.emp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.val;

import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(value = {AlreadyPresentException.class})
	public ResponseEntity<ExceptionModel> alreadyPresentException(AlreadyPresentException presentException){
		ExceptionModel model = new ExceptionModel();
		
		model.setDateTime(LocalDateTime.now());
		model.getMessage().add(presentException.getMessage());
		model.setCode(HttpStatus.BAD_REQUEST.toString());
		
		return new ResponseEntity<ExceptionModel>(model,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = { DataNotFoundException.class})
	public ResponseEntity<ExceptionModel> dataNotFoundException(DataNotFoundException dataNotFoundException){
		
		ExceptionModel model = new ExceptionModel();
		
		model.setDateTime(LocalDateTime.now());
		model.getMessage().add(dataNotFoundException.getMessage());
		model.setCode(HttpStatus.NOT_FOUND.toString());
		
		return new ResponseEntity<ExceptionModel>(model,HttpStatus.NOT_FOUND);
	}
}
