package com.lh.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "shop")
public class ShopController {

	@RequestMapping(value = "cart")
	public String cart(){
		return "shop/cart";
	}
	
	@RequestMapping(value = "order")
	public String order(){
		return "shop/order";
	}
	
	@RequestMapping(value = "payment")
	public String payment(){
		return "shop/payment";
	}
}
