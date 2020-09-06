package com.java.kundan.promotion.engine.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.kundan.promotion.engine.app.request.ProductDTO;
import com.java.kundan.promotion.engine.app.response.Response;
import com.java.kundan.promotion.engine.app.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping
	private Response insert(@RequestBody ProductDTO dto) {

		return service.save(dto);
	}

	@GetMapping
	public Response getByName(@RequestBody List<ProductDTO> dto) {
		return service.getByName(dto);
	}
}
