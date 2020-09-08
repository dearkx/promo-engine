package com.java.kundan.promotion.engine.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.kundan.promotion.engine.app.entity.Product;
import com.java.kundan.promotion.engine.app.exception.ProductNotFoundException;
import com.java.kundan.promotion.engine.app.repository.ProductRepository;
import com.java.kundan.promotion.engine.app.request.ProductDTO;
import com.java.kundan.promotion.engine.app.response.ProductResponse;
import com.java.kundan.promotion.engine.app.response.Response;
import com.java.kundan.promotion.engine.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	public Response save(List<ProductDTO> dtoList) {
		List<Product> list = new ArrayList<Product>();
		for (ProductDTO dto : dtoList) {
			Product p = new Product();
			p.setName(dto.getName());
			p.setPrice(dto.getPrice());
			Product product = repo.save(p);
			list.add(product);
		}
		
		return response(list);
	}

	private Response response(List<Product> list) {
		Response res = new Response();
		res.setProduct(list);
		return res;
	}

	@Override
	public Response getByName(List<ProductDTO> listOfProduct) {
		List<ProductResponse> productDTOList = new ArrayList<ProductResponse>();
		double totalAmount = 0;
		for (ProductDTO productDTO : listOfProduct) {
			Product product = repo.findByName(productDTO.getName());
			if (null != product) {

				if (productDTO.getName().equals(product.getName())) {
					double totalPrice = priceCalculator(productDTO.getNoOfproduct(), product.getPrice(),
							productDTO.getOffer(), productDTO.getMinBuyproductCountForOffer());
					product.setPrice(totalPrice);
					totalAmount = totalAmount + totalPrice;
				}
			} else {
				throw new ProductNotFoundException("Invalid Product : " + productDTO.getName());
			}

			ProductResponse productResponce = new ProductResponse();
			productResponce.setName(product.getName());
			productResponce.setPrice(product.getPrice());
			productResponce.setNoOfproduct(productDTO.getNoOfproduct());
			productDTOList.add(productResponce);

		}
		Response res = new Response();
		res.setProductDto(productDTOList);
		res.setTotalAmount(totalAmount);
		return res;
	}

	private double priceCalculator(int noOfProduct, double price, int offer, int minBuyproductCountForOffer) {
		if (noOfProduct == 1 || offer <= 0) {
			return noOfProduct * price;
		}
		return eligibleForPromotionOffer(noOfProduct, price, offer, minBuyproductCountForOffer);
	}

	private double eligibleForPromotionOffer(int totalProduct, double price, int offer,
			int mustBuyproductCountForOffer) {

		int eligiblePiarForDiscount = totalProduct / mustBuyproductCountForOffer;
		int notEligibleForDiscount = totalProduct % mustBuyproductCountForOffer;
		double afterDiscountPrice = 0;
		if (totalProduct > 0) {
			double originalCostOfProduct = eligiblePiarForDiscount * mustBuyproductCountForOffer * price;
			double totalDiscount = originalCostOfProduct * offer / 100;
			afterDiscountPrice = originalCostOfProduct - totalDiscount;
		}

		double productNotEligiblieForDiscountPrice = notEligibleForDiscount * price;
		if (afterDiscountPrice > 0) {
			double finalPriceOfProduct = afterDiscountPrice + productNotEligiblieForDiscountPrice;
			return finalPriceOfProduct;
		}
		return 0;
	}
}
