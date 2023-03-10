package com.bookstore.search.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.components.Search;
import com.bookstore.models.Book;
import com.bookstore.services.BookService;
import com.bookstore.util.Utility;


@Controller
@RequestMapping("searchby")
public class AdminSearch
{
	@Autowired private Search search;
	@Autowired private BookService bservice;
	@RequestMapping("bookid/admin")
	public String searchByBookid(Model model,long bid,HttpSession ses,HttpServletRequest req) 
	{
		search.getBookListByBookid(model,bid);
		setUrl(ses,req);
		return "admin/search/search-book-list";
	}
	@RequestMapping("author/admin")
	public String searchByAuthor(Model model,String author,HttpSession ses,HttpServletRequest req) 
	{
		Utility.setUrl(ses,req);
		search.getBookListByAuthor(model,author);
		return "admin/search/search-book-list";
	}
	@RequestMapping("title/admin")
	public String searchByTitle(Model model,String title,HttpServletRequest req,HttpSession ses) 
	{
		Utility.setUrl(ses,req);
		search.getBookListByTitle(model,title);
		return "admin/search/search-book-list";
	}
	@RequestMapping("category/admin")
	public String searchByCategory(Model model,String category,HttpServletRequest req,HttpSession ses) 
	{
		Utility.setUrl(ses,req);
		search.getBookListByCategory(model,category);
		return "admin/search/search-book-list";
	}
	@RequestMapping("publisher/admin")
	public String searchByPublisher(Model model,String publisher,HttpServletRequest req,HttpSession ses) 
	{
		Utility.setUrl(ses,req);
		search.getBookListByPublisher(model,publisher);
		return "admin/search/search-book-list";
	}
	@RequestMapping("book/editsave")
	public String updateBook(Book book,HttpSession ses) 
	{
		bservice.updateBook(book);
		return "redirect:"+ses.getAttribute("url");
	}
	@RequestMapping("book/remove")
	public String removeBook(long bid,HttpSession ses)
	{
		bservice.removeBook(bid);
		return "redirect:"+ses.getAttribute("url");
	}
	private void setUrl(HttpSession ses,HttpServletRequest req)
	{
		ses.setAttribute("url",req.getRequestURI()+"?"+req.getQueryString());
	}
}
