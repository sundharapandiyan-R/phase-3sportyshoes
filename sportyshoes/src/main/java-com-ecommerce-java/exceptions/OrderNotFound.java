package com.ecommerce.sportyshoes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@ResponseBody
public class OrderNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public OrderNotFound(String message) {
		super(message);

	}
}