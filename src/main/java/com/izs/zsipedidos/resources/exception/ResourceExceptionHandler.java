package com.izs.zsipedidos.resources.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.izs.zsipedidos.services.exeptions.ObjectNotFoundExeption;

import jakarta.servlet.http.HttpServletRequest;
/*
 *  permite manipular exceções
 */
@ControllerAdvice
public class ResourceExceptionHandler {
	/**
	 * Manipulador de exeçoes do resources
	 * Responsavel por capturar as Exceptions
	 */

	@ExceptionHandler(ObjectNotFoundExeption.class)
	public ResponseEntity<StarndardError> objectNotFoundException(ObjectNotFoundExeption e, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new StarndardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis()));
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StarndardError> dateIntegrity(DataIntegrityViolationException e, HttpServletRequest request){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new StarndardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis()));
	}
}
