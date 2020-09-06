package com.java.kundan.promotion.engine.app.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.java.kundan.promotion.engine.app.exception.ProductNotFoundException;
import com.java.kundan.promotion.engine.app.response.ErrorMessage;

@ControllerAdvice
public class ProductExceptionHandler {

	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleMessageNotFound(Exception e) {

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage("404", e.getMessage()));
	}
}
