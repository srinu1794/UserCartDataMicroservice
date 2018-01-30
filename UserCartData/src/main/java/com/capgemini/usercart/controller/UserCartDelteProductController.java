package com.capgemini.usercart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.usercart.model.UserCartModel;
import com.capgemini.usercart.services.DeleteProductCartService;

@RestController
@RequestMapping("/cart")
public class UserCartDelteProductController {

	@Autowired
	DeleteProductCartService deleteProductCartService;

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.POST)

	public UserCartModel deleteProduct(@RequestParam("userId") String userId, @RequestParam("productId") String productId) {

		return deleteProductCartService.deleteProduct(userId, productId);
	}

}