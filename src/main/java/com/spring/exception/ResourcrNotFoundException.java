package com.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourcrNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public ResourcrNotFoundException(String message) {
		super(message);
		this.msg=message;
		
	}
	public String  getmsg() {
		return this.msg;
	}
	

}
