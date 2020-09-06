package com.java.kundan.promotion.engine.app.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.java.kundan.promotion.engine.app.entity.Product;

import lombok.Data;

@Data
public class Response {
	
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Product> product;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<ProductResponse> productDto;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Double totalAmount;
}
