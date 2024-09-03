package com.app.exception;

import lombok.Getter;

@Getter
public class BookingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3006912882113400824L;

	public BookingException(String message, Throwable cause) {
		super(message, cause);

	}

	public BookingException(String message) {
		super(message);

	}
	
}
