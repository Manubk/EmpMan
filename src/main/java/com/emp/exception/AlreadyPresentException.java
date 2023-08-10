package com.emp.exception;

public class AlreadyPresentException extends RuntimeException {
	
	private String message ;
	
	
	public AlreadyPresentException(String message) {
		this.message = message;
	}
	
}
