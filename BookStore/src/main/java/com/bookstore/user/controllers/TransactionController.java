package com.bookstore.user.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookstore.models.BookTransaction;
import com.bookstore.services.TransactionService;

@Controller
@RequestMapping("transaction")
public class TransactionController
{
	@Autowired private TransactionService tservice;
	@RequestMapping("view-transaction")
	public String getTransactionDetails(Model model,HttpSession ses)
	{
		List<BookTransaction> list=tservice.getListByUserid((String)ses.getAttribute("userid"));
		model.addAttribute("list",list);
		return "user/purchase/transaction-list";
	}
}
