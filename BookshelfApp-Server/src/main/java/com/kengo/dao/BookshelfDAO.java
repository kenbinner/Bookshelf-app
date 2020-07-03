package com.kengo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kengo.model.Book;
import com.kengo.model.Customer;

@Repository
public interface BookshelfDAO {
	
	public List<Book> getBooks(Integer custId) throws Exception;
	
	public String addBook(Book book) throws Exception;
	
	public String removeBook(Integer bookId) throws Exception;
	
	public String updateBook(Book book) throws Exception;
	
	public void retrieveImageFile(Byte[] imageData, Integer bookId) throws Exception;
	
	public Customer authenticateCustomer(String emailId, String password);
	
}
