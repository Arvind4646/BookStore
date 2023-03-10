package com.bookstore.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.services.BookService;
import com.bookstore.models.User;
import com.bookstore.services.UserService;

@Controller
@RequestMapping("bookstore")
public class UserRegistration
{
	
	@Autowired
	private UserService service;
	@Autowired 
	BookService bookservice;
	
	@RequestMapping("register")
	public String getUserRegistration(Model model)
	{
		model.addAttribute("user",new User());
		return "user/user-registration/user-registration";
	}
	@RequestMapping("registerme")
	public String userRegistration(User user,Model model)
	{
		User u=service.getUser(user.getUserid());
		if(u!=null)
		{
			model.addAttribute("user",user);
			model.addAttribute("msg","This user id already exists.Choose other user id");
			return "user/user-registration/user-registration";
		}
		service.registerUser(user);
		model.addAttribute("name", user.getName());
		
		return "user/user-registration/register-msg";
	}
}
