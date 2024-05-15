package com.spring.exception;



import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandler {
 @org.springframework.web.bind.annotation.ExceptionHandler(ResourcrNotFoundException.class)
	public ResponseEntity<ErrorDetails> 
	handleResourcrNotFoundException(ResourcrNotFoundException exception,WebRequest request){
		//ResourcrNotFoundException resource=new ResourcrNotFoundException(exception.getMessage());
	 ErrorDetails error =new ErrorDetails(new Date(System.currentTimeMillis()),exception.getMessage(),request.getDescription(false));
			 
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
}
