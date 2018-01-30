package com.capgemini.usercart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.usercart.services.EmptyProductCartService;

@RestController
@RequestMapping("/cart")
public class UserCartEmptyController {

	@Autowired
	EmptyProductCartService emptyProductcartService;
	
	@RequestMapping(value = "/empty", method = RequestMethod.POST)
	public String create(@RequestParam("userId") String userId) {
		
		return emptyProductcartService.emptyCart(userId);
	}

		
}