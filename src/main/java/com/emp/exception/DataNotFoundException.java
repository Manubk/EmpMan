package com.emp.exception;

public class DataNotFoundException extends RuntimeException {

	private String message ;
	
	public DataNotFoundException(String message) {
		this.message = message;
	}
}
