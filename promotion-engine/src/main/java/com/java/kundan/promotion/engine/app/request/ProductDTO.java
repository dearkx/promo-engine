package com.java.kundan.promotion.engine.app.request;

import lombok.Data;

@Data
public class ProductDTO {
	
	
	 private String name;
	 private double price;
	 private int noOfproduct;
	 private int offer;
	 private int minBuyproductCountForOffer;
}
