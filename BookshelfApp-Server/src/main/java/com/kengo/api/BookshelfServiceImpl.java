package com.kengo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.kengo.controller.BookshelfController;
import com.kengo.model.Book;
import com.kengo.model.Customer;
import com.kengo.model.NewBook;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping
public class BookshelfServiceImpl implements BookshelfService{
	
	@Autowired
	BookshelfController bookshelfController;
	
	@PostMapping(value = "customerLogin")
	public ResponseEntity<Customer> authenticateCustomer(@RequestBody Customer customer) throws Exception {
		try {
			
			Customer customerfromDB = bookshelfController.authenticateCustomer(customer.getEmail(), customer.getPassword());
			
			return new ResponseEntity<Customer>(customerfromDB, HttpStatus.OK);
		} 
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
		}
	}
	
	@GetMapping(value = "getBooks/{custId}")
	public ResponseEntity<List<Book>> getBooks(@PathVariable("custId") Integer custId) throws Exception{
		try{
			List<Book> bookList = bookshelfController.getBooks(custId);
			return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@PostMapping(value = "addBook/{custId}")
	public ResponseEntity<String> addBook(@RequestBody NewBook newBook) throws Exception{
		try{
			Book book = new Book();
			book.setAuthor(newBook.getAuthor());
			book.setComments(newBook.getComments());
			book.setCustomer(newBook.getCustomer());
			book.setIsbn(newBook.getIsbn());
			book.setRating(newBook.getRating());
			book.setStatus(newBook.getStatus());
			book.setTitle(newBook.getTitle());
			book.setImage(bookshelfController.saveImageFile(newBook.getImage()));
			String title = bookshelfController.addBook(book);
			return new ResponseEntity<String>("\"" + title + "\"", HttpStatus.OK);
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
//	@PostMapping(value = "addImage/{custId}")
//	public ResponseEntity<String> addImage(@RequestParam("imageFile") MultipartFile file) throws Exception{
//		try{
//			bookshelfController.saveImageFile(file);
//			String title = bookshelfController.addBook(book);
//			return new ResponseEntity<String>("\"" + title + "\"", HttpStatus.OK);
//		}catch(Exception e){
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
//		}
//	}
	
	@PostMapping(value = "removeBook/{bookId}")
	public ResponseEntity<String> removeBook(@PathVariable("bookId") Integer bookId) throws Exception{
		try{
			String title = bookshelfController.removeBook(bookId);
			return new ResponseEntity<String>(title, HttpStatus.OK);
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	@PostMapping(value = "updateBook/{bookId}")
	public ResponseEntity<String> updateBook(@RequestBody Book book) throws Exception{
		try{
			String title = bookshelfController.updateBook(book);
			return new ResponseEntity<String>(title, HttpStatus.OK);
		}catch(Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

}
