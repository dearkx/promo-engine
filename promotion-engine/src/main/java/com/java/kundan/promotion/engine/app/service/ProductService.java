package com.java.kundan.promotion.engine.app.service;

import java.util.List;

import com.java.kundan.promotion.engine.app.request.ProductDTO;
import com.java.kundan.promotion.engine.app.response.Response;

public interface ProductService {
	public Response save(ProductDTO dto);
	public Response getByName(List<ProductDTO> listOfProduct);
}
