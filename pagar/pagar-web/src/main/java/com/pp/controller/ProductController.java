package com.pp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pp.model.ProductDto;
import com.pp.model.UserDto;
import com.pp.service.ProductService;
import com.pp.service.RegistrationService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/product")
	public String showEntry(Map<String, Object> map) {
		System.out.println("Inside showEntry method in ProductController");
		ProductDto pro = new ProductDto();
		map.put("Pro", pro);
		return "product";
	}
	
	@RequestMapping(value = "/productRegistration", method = RequestMethod.POST)
	public String entryAction1(@ModelAttribute("Pro") ProductDto productRegistration,Map<String, Object> map,Model model) {
		System.out.println("Inside productRegistrationAction1 method in ProductController");

		System.out.println("Product name in ProductController >>" + productRegistration.getProductName());
		System.out.println("Product price in ProductController >>" + productRegistration.getPrice());
		System.out.println("Product description in ProductController >>" + productRegistration.getDescription());
		System.out.println("Product expireDate in ProductController >>" + productRegistration.getExpireDate());
		System.out.println("Product code in ProductController >>" + productRegistration.getProductCode());
		System.out.println("Product id in ProductController >>" + productRegistration.getProductId());

		productService.productRegistration(productRegistration);
		
		List<ProductDto> productList=productService.getAllProduct();
		model.addAttribute("List", productList);

		for (int counter = 0; counter < productList.size(); counter++) {
			// System.out.println(login1.get(counter));
			System.out.println("Product name in productList >>" + productList.get(counter).getProductName());
			System.out.println("Product price in productList >>" + productList.get(counter).getPrice());
			System.out.println("Product description in productList >>" + productList.get(counter).getDescription());
			System.out.println("Product expireDate in productList >>" + productList.get(counter).getExpireDate());
			System.out.println("Product code in productList >>" + productList.get(counter).getProductCode());
			System.out.println("Product id in productList >>" + productList.get(counter).getProductId());
		}
		return "product";
	}
}
