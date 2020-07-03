package com.kengo.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kengo.dao.BookshelfDAO;
import com.kengo.model.Book;
import com.kengo.model.Customer;

@Service(value = "bookshelfService")
public class BookshelfServiceImpl implements BookshelfService{
	
	@Autowired
	private BookshelfDAO bookshelfDAO;

	@Override
	public List<Book> getBooks(Integer custId) throws Exception {
		List<Book> bookList = bookshelfDAO.getBooks(custId);
		return bookList;
	}

	@Override
	public String addBook(Book book) throws Exception {
		String title = bookshelfDAO.addBook(book);
		return title;
	}

	@Override
	public String removeBook(Integer bookId) throws Exception {
		String title = bookshelfDAO.removeBook(bookId);
		return title;
	}

	@Override
	public String updateBook(Book book) throws Exception {
		String title = bookshelfDAO.updateBook(book);
		return title;
	}

	@Override
	public Byte[] saveImageFile(MultipartFile file) throws Exception {
		Byte[] image = new Byte[file.getBytes().length];
			
		int i = 0;
			
		for(byte b : file.getBytes()){
			image[i++] = b;
		}
			
		return image;
	}
	
	@Override
	public Customer authenticateCustomer(String emailId, String password) throws Exception {
		Customer customer = bookshelfDAO.authenticateCustomer(emailId, password);
		if(customer == null){
			throw new Exception("Invalid Credentials");
		}else
		return customer;
	}


}
