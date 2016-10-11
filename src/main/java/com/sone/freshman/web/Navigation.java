package com.sone.freshman.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Navigation {
	@RequestMapping(value="/users",method = RequestMethod.GET)
	public String showUser() {
		return "user/list";
	}	
}
