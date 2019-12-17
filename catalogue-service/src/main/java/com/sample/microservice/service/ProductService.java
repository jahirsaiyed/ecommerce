package com.sample.microservice.service;

import java.util.Optional;

import com.sample.microservice.model.Product;

public interface ProductService {

	Optional<Product> getProductById(String productId);

}
