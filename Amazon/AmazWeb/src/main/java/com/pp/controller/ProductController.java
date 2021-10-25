package com.pp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pp.model.Product;
import com.pp.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping("/showProduct")
	public String showProduct(Map<String,Object> map,Model model) {
		System.out.println("Inside showProduct controller");
		map.put("productDto", new Product());

		List<Product> products = productService.getProducts();
		for(Product product1:products) {
			System.out.println(product1);
		}		
		if(products.isEmpty()) {
			model.addAttribute("productList",null);
		}else {
			model.addAttribute("productList",products);
		}
		return "product";
	}

	@RequestMapping(value="/submitProduct",method = RequestMethod.POST)
	public String submitProduct(@ModelAttribute("productDto") Product product,Model model){

		System.out.println("Inside submitProduct");
		productService.saveProduct(product);	

		/*
		 * byte[] prodImage=product.getFile(); if(prodImage.length>0){ String
		 * paths=Paths.get("C:/Users/karan/Documents/Images/"+
		 * product.getProductId()+".png"); try { FileWriter f = new FileWriter(new
		 * File(paths)); prodImage.transferTo(new File(paths.toString())); } catch
		 * (IllegalStateException e) { e.printStackTrace(); } catch (IOException e) {
		 * e.printStackTrace(); } }
		 */


		List<Product> products = productService.getProducts();
		model.addAttribute("productList",products);

		return "product";
	}
}