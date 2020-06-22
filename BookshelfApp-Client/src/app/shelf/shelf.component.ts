import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Customer } from "../models/Customer";
import { Book } from "../models/book";
import { ShelfService } from "./shelf.service";
import { Router } from '@angular/router';

@Component({
  selector: 'app-shelf',
  templateUrl: './shelf.component.html',
  styleUrls: ['./shelf.component.css']
})
export class ShelfComponent implements OnInit {

  newBook: Book;
  customer: Customer;
  bookList: Book[];
  addBookForm: FormGroup;
  errorMessage: string;
  successMessage: string;

  viewDetails: boolean = false;
  addBookScreen: boolean = false;
  selectedBook: Book;

  constructor(private fb: FormBuilder, private shelfService: ShelfService, private router: Router) { }

  ngOnInit() {
    this.customer = JSON.parse(sessionStorage.getItem("customer"));
    this.getBooks(this.customer.customerId);
  }

  createAddBookForm() {
    this.addBookForm = this.fb.group({
      title: [this.newBook.title, [Validators.required]],
      author: [this.newBook.author],
      isbn: [this.newBook.isbn],
      status: [this.newBook.status],
      rating: [this.newBook.rating],
      comments: [this.newBook.comments]
    });
  }

  setSelectedBook(book: Book){
    this.selectedBook = book;
    this.viewDetails = true;
  }

  getBooks(custId: number){
    this.errorMessage = null;
    this.successMessage = null;
    this.shelfService.getBooks(custId).subscribe(
      (response) => {
        this.bookList = response
      },
      (error) => {
        this.errorMessage = <any>error;
      }
    )
  }

  removeBook(bookId: number){
    this.errorMessage = null;
    this.successMessage = null;
    this.shelfService.removeBook(bookId).subscribe(
      (response) => {
        this.successMessage = response
      },
      (error) => {
        this.errorMessage = <any>error;
      }
    )
  }

  addBook(book: Book){
    this.errorMessage = null;
    this.successMessage = null;
    this.shelfService.addBook(book).subscribe(
      (response) => {
        this.successMessage = response
      },
      (error) => {
        this.errorMessage = <any>error;
      }
    )
  }
}
