package com.pp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pp.model.ProductDto;
import com.pp.model.UserDto;

@Repository
public class ProductRepository {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public ProductDto saveProductDeatils(ProductDto productRegistration) {
		if (productRegistration != null) {
			hibernateTemplate.saveOrUpdate(productRegistration);

			System.out.println("Inside saveProductDetails method in productRepository ");

			System.out.println("Product name in productRepository >>" + productRegistration.getProductName());
			System.out.println("Product price in productRepository >>" + productRegistration.getPrice());
			System.out.println("Product description in productRepository >>" + productRegistration.getDescription());
			System.out.println("Product expireDate in productRepository >>" + productRegistration.getExpireDate());
			System.out.println("Product code in productRepository >>" + productRegistration.getProductCode());
			System.out.println("Product id in productRepository >>" + productRegistration.getProductId());
			return productRegistration;
		} else {
			return null;
		}
	}

	public List<ProductDto> getAllProduct() {

		List<ProductDto> product = (List<ProductDto>) hibernateTemplate.find("from ProductDto");
		System.out.println("Inside getAllProduct method in productRepository ");
		for (int counter = 0; counter < product.size(); counter++) {
			// System.out.println(login1.get(counter));
			System.out.println("Product name in productRepository >>" + product.get(counter).getProductName());
			System.out.println("Product price in productRepository >>" + product.get(counter).getPrice());
			System.out.println("Product description in productRepository >>" + product.get(counter).getDescription());
			System.out.println("Product expireDate in productRepository >>" + product.get(counter).getExpireDate());
			System.out.println("Product code in productRepository >>" + product.get(counter).getProductCode());
			System.out.println("Product id in productRepository >>" + product.get(counter).getProductId());
		}

		return product;

	}
}
