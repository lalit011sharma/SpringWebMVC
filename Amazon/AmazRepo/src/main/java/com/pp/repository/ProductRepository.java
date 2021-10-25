package com.pp.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pp.model.Product;

@Repository
public class ProductRepository {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public void persistProduct(Product product) {
		System.out.println("Inside productRepo");
		if(product != null) {
			hibernateTemplate.saveOrUpdate(product);
		}else {
			System.out.println("Insertion failed");
		}
	}
	public List<Product> findProducts() {
		List<Product> productList = hibernateTemplate.find("from Product");
		
		return productList;
	}

}
