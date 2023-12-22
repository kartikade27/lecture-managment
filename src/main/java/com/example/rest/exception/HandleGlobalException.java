package com.example.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleGlobalException {

	@ExceptionHandler(CustomeException.class)
	public ResponseEntity<ProblemDetail>customeExceptionHandling(CustomeException ex){
		ProblemDetail problemDetail=ProblemDetail.forStatus(HttpStatus.NOT_ACCEPTABLE);
		problemDetail.setTitle(ex.getMessage());
		return new ResponseEntity<ProblemDetail>(problemDetail,HttpStatus.NOT_ACCEPTABLE);
	}
}
