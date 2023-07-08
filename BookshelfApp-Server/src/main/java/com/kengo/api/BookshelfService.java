package com.kengo.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.kengo.model.Book;
import com.kengo.model.Customer;
import com.kengo.model.NewBook;

public interface BookshelfService {
	
	public ResponseEntity<Customer> authenticateCustomer(@RequestBody Customer customer) throws Exception;
	
	public ResponseEntity<List<Book>> getBooks(@PathVariable("custId") Integer custId) throws Exception;
	
	public ResponseEntity<String> addBook(@RequestBody NewBook newBook) throws Exception;
	
	public ResponseEntity<String> removeBook(@PathVariable("bookId") Integer bookId) throws Exception;
	
	public ResponseEntity<String> updateBook(@RequestBody Book book) throws Exception;

}
