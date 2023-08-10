package com.emp.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;

import lombok.Data;

@Data
public class ExceptionModel {
	
	private LocalDateTime dateTime;
	
	private String code;
	
	private ArrayList<String> message;
	
	private String path;
	
	ExceptionModel(){
		this.message = new ArrayList<String>();
	}
}
