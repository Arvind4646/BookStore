package com.bookstore.login.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookstore")
public class LoginViewController
{
	@RequestMapping("userlogin")
	public String getLoginView(String msg,Model model)
	{
		model.addAttribute("msg",msg);
		return "user/user-login/user-login";
	}
	@RequestMapping("adminlogin")
	public String getLoginView()
	{
		return "admin/admin-login/admin-login";
	}
}
