package com.bookstore.admin.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookstore")
public class AdminLoginController 
{
	@RequestMapping("admin-authentication")
	public String validateLogin(String aid,String apass,Model model)
	{
		if(aid.equals("admin") && apass.equals("admin"))
		{
			return "redirect:/bookstore/home";
		}
		model.addAttribute("msg", "Authnetication failed...");
		return "admin/admin-login/admin-login";
	}
	@RequestMapping("adminlogout")
	public String adminLogout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/bookstore/adminlogin";
	}
}
