package com.pp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.model.Product;
import com.pp.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public void saveProduct(Product product) {
		System.out.println("Inside saveProduct service");	
		productRepository.persistProduct(product);
	}

	public List<Product> getProducts() {
		List<Product> products = productRepository.findProducts();
		return products;
	}

}
