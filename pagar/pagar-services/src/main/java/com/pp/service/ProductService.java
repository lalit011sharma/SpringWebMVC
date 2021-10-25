package com.pp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pp.model.ProductDto;
import com.pp.model.UserDto;
import com.pp.repository.ProductRepository;
import com.pp.repository.RegistrationRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
    public void productRegistration(ProductDto productRegistration) {
    	 
    	 System.out.println("Inside productRegistration method in ProductService ");
 		
    	 System.out.println("Product name in ProductService >>" + productRegistration.getProductName());
 		System.out.println("Product price in ProductService >>" + productRegistration.getPrice());
 		System.out.println("Product description in ProductService >>" + productRegistration.getDescription());
 		System.out.println("Product expireDate in ProductService >>" + productRegistration.getExpireDate());
 		System.out.println("Product code in ProductService >>" + productRegistration.getProductCode());
 		System.out.println("Product id in ProductService >>" + productRegistration.getProductId());
 		
 		productRepository.saveProductDeatils(productRegistration);
     }
    
    public List<ProductDto> getAllProduct(){
    	
    	return productRepository.getAllProduct();
    }
}
