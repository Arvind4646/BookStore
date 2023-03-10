package com.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.models.BookTransaction;



public interface TransactionRepository extends JpaRepository<BookTransaction,Integer> 
{
	List<BookTransaction> findByUserid(String uid);
}
