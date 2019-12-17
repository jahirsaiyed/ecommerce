package com.sample.microservice.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sample.microservice.model.Product;
import com.sample.microservice.service.ProductService;

@Service
@Qualifier("dummyProductService")
public class DummyProductService implements ProductService {

	private List<Product> products = Arrays.asList(new Product(1l, "Apple Iphone X"),
			new Product(2l, "Samsung Galaxy 11"), new Product(3l, "DJI Pro Drone"),
			new Product(4l, "Nissan Land Rover"), new Product(5l, "Intel ThinkPad 486"));

	@Override
	public Optional<Product> getProductById(String productId) {
		return products
				.parallelStream()
				.filter(p -> StringUtils.equalsIgnoreCase(p.getId().toString(), productId))
				.findFirst();
	}

}
