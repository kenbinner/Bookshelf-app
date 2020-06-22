package com.kengo;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.kengo.model.Book;
import com.kengo.service.BookshelfService;

@SpringBootApplication
public class BookshelfAppServer{// implements CommandLineRunner{
	
	@Autowired
	Environment environment;
	
	@Autowired
	private BookshelfService bookshelfService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookshelfAppServer.class, args);
	}
	
	/*
	@Override
	public void run(String... args) throws Exception {
		//addBook();
		//removeBook();
		//updateBook();
		//getBooks();
	}
	
	public void getBooks(){
		try{
			List<Book> bookList = bookshelfService.getBooks(1);
			for(Book book : bookList){
				System.out.println(book.getTitle());
				System.out.println(book.getAuthor());
				System.out.println(book.getIsbn());
				System.out.println(book.getStatus());
				System.out.println(book.getRating());
				System.out.println(book.getComments());
				System.out.println(book.getIsbn());
				bookshelfService.retrieveImageFile(book.getImage());
				System.out.println("-------------");
			}
			System.out.println(bookList.get(10).getImage().length);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void addBook(){
		try{
			Book book = new Book();
			book.setAuthor("Jordan B Peterson");
			book.setComments("Really amazing stuff");
			book.setCustomer(1);
			book.setIsbn("434523451");
			book.setRating(5);
			book.setStatus("complete");
			book.setTitle("12 Rules for Life: An Antidote to Chaos");
			
			File file = new File("C:\\Users\\kengo.binner\\Desktop\\other\\BookshelfApp\\BookshelfApp-Server\\src\\main\\resources\\12RulesCover.jpg");
			FileInputStream input = new FileInputStream(file);
			MultipartFile multifile= new MockMultipartFile("file", input);
			book.setImage(bookshelfService.saveImageFile(multifile));
			
			String title = bookshelfService.addBook(book);
			System.out.println("Successfully added "+title+" to bookshelf");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void removeBook(){
		try{
			String title = bookshelfService.removeBook(3);
			System.out.println("Successfully removed "+title+" from bookshelf");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateBook(){
		try{
			Book book = new Book();
			book.setBookId(1);
			book.setAuthor("Patrick McCarthy");
			book.setComments("Super Karate stuff");
			book.setCustomer(1);
			book.setIsbn("9784805313848");
			book.setRating(4);
			book.setStatus("complete");
			book.setTitle("Bubishi");
			String title = bookshelfService.updateBook(book);
			System.out.println("Updated "+title+" in bookshelf");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	*/
}
