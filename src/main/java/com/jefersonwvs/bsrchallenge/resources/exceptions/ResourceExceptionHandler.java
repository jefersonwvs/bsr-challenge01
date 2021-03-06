package com.jefersonwvs.bsrchallenge.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jefersonwvs.bsrchallenge.services.exceptions.ClientNotFoundException;
import com.jefersonwvs.bsrchallenge.services.exceptions.DatabaseException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ClientNotFoundException.class)
	public ResponseEntity<StandardError> clientNotFound(
														ClientNotFoundException e,
														HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError();
		
		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setError("Recurso não encontrado");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> databaseException(
														DatabaseException e,
														HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError error = new StandardError();
		
		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setError("Erro de banco de dados");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
	}
	
}
