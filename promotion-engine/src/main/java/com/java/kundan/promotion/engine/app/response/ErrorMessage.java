package com.java.kundan.promotion.engine.app.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage{
	private String status;
	private String message;
}
