package com.gls.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String welcomeAdmin(ModelMap model) {
		System.out.println("AdminController:: welcomeAdmin()");
		model.addAttribute("message", "Welcome ");
		return "menu";
	}

}
