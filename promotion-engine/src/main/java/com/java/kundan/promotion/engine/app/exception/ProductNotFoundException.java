package com.java.kundan.promotion.engine.app.exception;

public class ProductNotFoundException extends RuntimeException{

	/**
	 */
	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundException(String message){
		super(message);
	}

}
