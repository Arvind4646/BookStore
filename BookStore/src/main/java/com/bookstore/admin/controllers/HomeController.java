package com.bookstore.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookstore")
public class HomeController
{
	@RequestMapping("home")
	public String getLoginView()
	{
		return "admin/home/home";
	}
	
}

