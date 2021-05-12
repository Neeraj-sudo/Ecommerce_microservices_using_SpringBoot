package com.store.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class StoreNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -657569980880616452L;
	public StoreNotFoundException(String message) {
		super(message);
	}
}