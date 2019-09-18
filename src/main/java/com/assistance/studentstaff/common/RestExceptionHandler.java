package com.assistance.studentstaff.common;

import javax.persistence.NonUniqueResultException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	ResponseUtility responseUtility = new ResponseUtility();

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return responseUtility.buildErrorResponse(ex, HttpStatus.BAD_REQUEST, "Parameter Values are invalid");
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return responseUtility.buildErrorResponse(ex, HttpStatus.BAD_REQUEST, "Correct the invalid input field");
	}

	@ExceptionHandler(NonUniqueResultException.class)
	public ResponseEntity<Object> handleNonUniqueResultException(Exception ex, WebRequest request) {
		return responseUtility.buildErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected Error");
	}

	@ExceptionHandler(CustomGenericException.class)
	public ResponseEntity<Object> handleCustomGenericException(CustomGenericException ex, WebRequest request) {
		ResponseEntity<Object> res = responseUtility.buildErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, ex.getErrMsg());
		return res;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		return responseUtility.buildErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected Error");
	}
}