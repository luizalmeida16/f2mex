package com.luizalmeida.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
	
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Value can't be negative")
public class NegativeValueException extends Exception {

	private static final long serialVersionUID = 1L;

	public NegativeValueException(String msg) {
        super(msg);
    }
}
