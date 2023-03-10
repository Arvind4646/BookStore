package com.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bookstore.repositories.BookRepository;
import com.bookstore.models.Book;

@Service
public class BookService 
{
	@Autowired
	private BookRepository repo;

	public Page<Book> getBookList(int pn) 
	{
		Pageable p=PageRequest.of(pn,3);
		return repo.findAll(p);
	}
	public void saveBook(Book book) 
	{
		System.out.println("Data layer is called...");
		repo.save(book);
	}
	public void removeBook(long bid)
	{
		repo.deleteById(bid);
	}
	public Book getBook(long bid) 
	{
		return repo.findById(bid).orElse(null);
	}
	public void updateBook(Book book) 
	{
		repo.save(book);
	}
	public List<Book> getOutOfStockList() 
	{
		return repo.getOutOfStock();
	}
	public List<Book> getBookListByAuthor(String author)
	{
		return repo.findByAuthor(author);
	}
	public List<Book> getBookListByTitle(String title)
	{
		return repo.findByTitle(title);
	}
	public List<Book> getBookListByCategory(String category) 
	{
		return repo.findByCategory(category);
	}
	public List<Book> getBookListByPublisher(String publisher) 
	{
		return repo.findByPublisher(publisher);
	}
	public List<Book> getBookListById(long bid) 
	{
		return repo.findByBid(bid);
	}
	public void updateNoOfCopies(int quantity, long bid)
	{
		repo.updateCopies(quantity, bid);
	}
}
