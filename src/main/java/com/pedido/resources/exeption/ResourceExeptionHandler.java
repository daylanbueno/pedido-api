package com.pedido.resources.exeption;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pedido.services.exeption.ObjectNotFoundExeption;

@ControllerAdvice
public class ResourceExeptionHandler {
	
	@ExceptionHandler(ObjectNotFoundExeption.class)
	public ResponseEntity<StandarError> objectNotFound(ObjectNotFoundExeption e, HttpServletRequest request) {
		StandarError erro = new StandarError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
}
