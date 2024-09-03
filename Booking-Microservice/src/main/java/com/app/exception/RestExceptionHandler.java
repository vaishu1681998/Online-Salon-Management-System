package com.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.app.dto.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(BookingException.class)
	public ResponseEntity<ErrorResponse> handleException(BookingException e, HttpServletRequest request) {
		return new ResponseEntity<>(createBadRequestResponse(e.getMessage(), request), HttpStatus.BAD_REQUEST);
	}

	private ErrorResponse createBadRequestResponse(String localMessage, HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(localMessage);
		errorResponse.setLocalDateTime(LocalDateTime.now());
		errorResponse.setPath(request.getRequestURI());
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		return errorResponse;
	}
}
