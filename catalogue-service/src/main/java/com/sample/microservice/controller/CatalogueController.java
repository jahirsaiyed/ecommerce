package com.sample.microservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sample.microservice.model.Categories;
import com.sample.microservice.model.Product;
import com.sample.microservice.service.ProductService;

@RestController
public class CatalogueController {
	
	@Autowired
	@Qualifier("dummyProductService")
	private ProductService productService;

	@GetMapping("/category")
	public List<Categories> getAllCategories() {
		return Arrays.asList(new Categories());
	}

	@GetMapping("/product/category/{catId}")
	public List<Product> getAllProductsForCategory(@PathVariable("catId") String categoryId) {
		return Arrays.asList(new Product());
	}

	@GetMapping("/product/{productId}")
	public Optional<Product> getProduct(@PathVariable("productId") String productId) {
		return productService.getProductById(productId);
	}
}
