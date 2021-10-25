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
import com.pp.model.UserDto;
import com.pp.service.LoginService;
import com.pp.service.ProductService;


@Controller
public class LoginController{
	
	@Autowired
	private LoginService logSer;
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/showLogin")
	public String showLogin(Map<String, Object> map) {
		System.out.println("Inside Login Controller");
		map.put("UserDtoKey", new UserDto());
		return "login";
	}
	
	@RequestMapping(value = "/submitLogin", method = RequestMethod.POST)
	public String submitLogin(@ModelAttribute("UserDtoKey") UserDto login,Map<String,Object> map,Model model) {
		System.out.println("Inside submitLogin method");
		
		System.out.println("Email: "+login.getEmailId());
		System.out.println("Password: "+login.getPassword());
		
		if(logSer.userSignIn(login)) {
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
		return "login";
	}
}