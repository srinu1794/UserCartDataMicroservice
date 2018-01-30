package com.capgemini.usercart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.usercart.model.UserCartModel;
import com.capgemini.usercart.services.UserCartDetailService;

@RestController
@RequestMapping("/cart")
public class UserCartDetailController {

	@Autowired
	UserCartDetailService userCartDetailService;

	@RequestMapping(value = "/detail", method = RequestMethod.GET)

	public String getData(@RequestParam("userId") String userID,Model model) {

	 UserCartModel userCartModel = userCartDetailService.getData(userID);
	 model.addAttribute("detailsUserCart", userCartModel);
	 return "detailsUserCart";

	}

}