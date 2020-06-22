package com.kengo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kengo.model.Book;

@Entity
@Table(name="CUSTOMERS")
public class CustomerEntity {
	
	@Id
	@Column(name  = "CUSTOMERID")
	@SequenceGenerator(name="pkgen",  sequenceName="customer_seq")
	@GeneratedValue(generator="pkgen",strategy=GenerationType.SEQUENCE)
	private Integer customerId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER")
	private List<BookEntity> bookList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public List<BookEntity> getBookList() {
		return bookList;
	}
	public void setBookList(List<BookEntity> bookList) {
		this.bookList = bookList;
	}
	
	
}
