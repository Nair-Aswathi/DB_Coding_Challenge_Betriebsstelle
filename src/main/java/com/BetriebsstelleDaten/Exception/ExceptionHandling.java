package com.BetriebsstelleDaten.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.ServletRequestBindingException;

@ControllerAdvice
public class ExceptionHandling {
	
	@ExceptionHandler(ServletRequestBindingException.class)
	private ResponseEntity<Object> handleHeaderException(Exception ex, HttpStatus badRequest) {
		Exception error = new Exception("Bad Request");
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	private ResponseEntity<Object> handleAllException(Exception ex, HttpStatus badRequest) {
		Exception error = new Exception("Server Error");
		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
