package com.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.models.BookTransaction;
import com.bookstore.repositories.TransactionRepository;

@Service
public class TransactionService 
{
	@Autowired private TransactionRepository repo;

	public void saveTransaction(BookTransaction tr) 
	{
		repo.save(tr);
	}
	public List<BookTransaction> getListByUserid(String uid) 
	{
		return repo.findByUserid(uid);
	}
}
