package com.ecommerce.sportyshoes.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.ecommerce.sportyshoes.exceptions.UserNotFound;

@ControllerAdvice
public class UserExceptionController {
	
	@ExceptionHandler(value = UserNotFound.class)
	public ResponseEntity<Object> exception(UserNotFound exception) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}