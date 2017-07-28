package com.lh.site.controller.passport;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "passport")
public class RegisterController{
	
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register(ModelMap model) {
		return "passport/register";
	}
	
}
