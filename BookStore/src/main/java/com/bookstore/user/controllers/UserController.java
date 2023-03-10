package com.bookstore.user.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.models.BookCategory;
import com.bookstore.models.BookPublisher;
import com.bookstore.repositories.CategoryRepository;
import com.bookstore.repositories.PublisherRepository;
import com.bookstore.util.Utility;



@Controller
@RequestMapping("user")
public class UserController
{
	@Autowired private CategoryRepository crepo;
	@Autowired private PublisherRepository prepo;
	@RequestMapping("home")
	public String userHome(Model model,HttpSession ses) 
	{
		model.addAttribute("username",ses.getAttribute("name"));
		return "user/home/home";
	}
	@RequestMapping("searchbooks")
	public String searchBooks(Model model,HttpSession ses,HttpServletRequest req)
	{
		Utility.setUrl(ses, req);
		List<BookCategory> clist=crepo.findAll();
		model.addAttribute("clist",clist);
		List<BookPublisher> plist=prepo.findAll();
		model.addAttribute("plist",plist);
		return "user/search/search-books";
	}
}
