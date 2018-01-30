package com.capgemini.usercart.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.usercart.model.UserCartModel;
import com.capgemini.usercart.services.AddProductCartService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/cart")
@Slf4j
public class UserCartAddController {

	@Autowired
	AddProductCartService addProductcartService;
	

	@RequestMapping(value = "/add", method = RequestMethod.POST)

	public UserCartModel create(@RequestParam("userId") String userId,
			@RequestParam("productId") String productId,
			@RequestParam("quantity") String quantity) {
		log.info(userId+" "+productId);
		return addProductcartService.addProduct(userId, productId, quantity);
	
	}

	
}