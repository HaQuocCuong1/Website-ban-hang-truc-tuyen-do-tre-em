/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopbandotreem.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
/**
 *
 * @author ASUS
 */
@ControllerAdvice
public class ExceptionHandler {
        @org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(NotFoundException exc) {
		
		// create CustomerErrorResponse
		
		ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getMessage(),
                System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	// Add another exception handler ... to catch any exception (catch all)

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception exc) {
		
		// create CustomerErrorResponse
		
		ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
