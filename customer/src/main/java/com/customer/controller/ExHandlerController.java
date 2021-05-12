package com.customer.controller;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.customer.exceptions.CustomerNotFoundException;
import com.customer.exceptions.ErrorDetails;

//@ControllerAdvice
//@RestController
public class ExHandlerController extends ResponseEntityExceptionHandler{

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleCustomerNotFoundEx(CustomerNotFoundException ex, 
			WebRequest webRequest){
		System.out.println("--------------customer not found -----------------");
		ErrorDetails details=new ErrorDetails(new Date(), ex.getMessage(),
				webRequest.getDescription(false));
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(details);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAnyOtherEx(Exception ex, 
			WebRequest webRequest){
		System.out.println("--------------any other ex-----------------");
		ErrorDetails details=new ErrorDetails(new Date(), ex.getMessage(),
				webRequest.getDescription(false));
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(details);
	}

	//4 step
	//this method will handle data validation error(service side)
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",
			      ex.getBindingResult().toString());
			  return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
}






