package com.kengo.controller;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kengo.model.Book;
import com.kengo.model.Customer;

@Service
public interface BookshelfController {
	
	public List<Book> getBooks(Integer custId) throws Exception;
	
	public String addBook(Book book) throws Exception;
	
	public String removeBook(Integer bookId) throws Exception;
	
	public String updateBook(Book book) throws Exception;
	
	public Byte[] saveImageFile(MultipartFile file) throws Exception;
	
	public Customer authenticateCustomer(String emailId, String password) throws Exception;
	
}
