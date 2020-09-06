package com.java.kundan.promotion.engine.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.kundan.promotion.engine.app.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public Product findByName(String productName);
}
