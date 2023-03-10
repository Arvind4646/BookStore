package com.bookstore.admin.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.models.Book;
import com.bookstore.models.BookCategory;
import com.bookstore.models.BookPublisher;
import com.bookstore.services.BookService;
import com.bookstore.repositories.CategoryRepository;
import com.bookstore.repositories.PublisherRepository;

import com.bookstore.util.Utility;


@Controller
@RequestMapping("bookstore/book")
public class BookController 
{
	@Autowired
	private BookService service;
	@Autowired private CategoryRepository crepo; 
	@Autowired private PublisherRepository prepo; 
	
	@RequestMapping("update")
	public String getBookList(Model model,int pn,HttpSession ses,HttpServletRequest req) 
	{
		Utility.setUrl(ses,req);
		Page<Book> plist=service.getBookList(pn-1);
		List<Book> list=plist.toList();
		model.addAttribute("tp",plist.getTotalPages());
		model.addAttribute("pn",pn);
		ses.setAttribute("pn",pn);
		model.addAttribute("list",list);
		return "admin/book/book-list";
	}
	@RequestMapping("add")
	public String addBookForm(Model model) 
	{
		List<BookCategory> clist=crepo.findAll();
		model.addAttribute("clist",clist);
		List<BookPublisher> plist=prepo.findAll();
		model.addAttribute("plist",plist);
		return "admin/book/add-book";
	}
	@RequestMapping("save")
	public String addBook(Book book) 
	{
		System.out.println("Susiness layer called...");
		service.saveBook(book);
		return "redirect:/bookstore/book/update?pn=1";
	}
	@RequestMapping("remove")
	public String removeBook(long bid,HttpSession ses)
	{
		service.removeBook(bid);
		return "redirect:update?pn="+ses.getAttribute("pn");
	}
	@RequestMapping("edit")
	public String getEditForm(long bid,Model model) 
	{
		Book book=service.getBook(bid);
		model.addAttribute("book", book);
		return "admin/book/edit-book";
	}
	@RequestMapping("editsave")
	public String updateBook(Book book,HttpSession ses) 
	{
		service.updateBook(book);
		return "redirect:"+ses.getAttribute("url");
	}
	@RequestMapping("findall")
	public String findAll(HttpSession ses)
	{
		ses.setAttribute("author", null);
		return "redirect:/admin/booklist?pn=1";
	}
	@RequestMapping("searchbooks")
	public String searchBooks(Model model) 
	{
		List<BookCategory> clist=crepo.findAll();
		model.addAttribute("clist",clist);
		List<BookPublisher> plist=prepo.findAll();
		model.addAttribute("plist",plist);
		return "admin/search/search-books";
	}
}
