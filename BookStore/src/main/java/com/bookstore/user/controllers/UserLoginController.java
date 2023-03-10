package com.bookstore.user.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookstore.services.BookService;
import com.bookstore.models.User;
import com.bookstore.services.UserService;


@Controller
@RequestMapping("bookstore")
public class UserLoginController
{
	@Autowired
	private UserService service;
	@Autowired BookService bookservice;
	
	@RequestMapping("user-authentication")
	public String userLogin(String userid,String password,RedirectAttributes at,HttpSession session)
	{
		User dbuser=service.getUser(userid);
		if(dbuser!=null)
		{
			if(dbuser.getPassword().trim().equals(password.trim()))
			{
				session.setAttribute("userid",userid);
				session.setAttribute("password",password);
				session.setAttribute("name",dbuser.getName());
				return "redirect:/user/home";
			}
		}
		at.addAttribute("msg", "User id or password is incorrect");
		return "redirect:/bookstore/userlogin";
	}
	@RequestMapping("userlogout")
	public String userLogout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/bookstore/userlogin";
	}
}
