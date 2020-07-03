import { Component, OnInit } from '@angular/core';
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
  errorMessage: string;
  successMessage: string;

  viewDetails: boolean = false;
  selectedBook: Book;

  constructor(private shelfService: ShelfService, private router: Router) { }

  ngOnInit() {
    this.customer = JSON.parse(sessionStorage.getItem("customer"));
    this.getBooks(this.customer.customerId);
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
    alert("Hello! I am an alert box!!");
    this.errorMessage = null;
    this.successMessage = null;
    this.shelfService.removeBook(bookId).subscribe(
      (response) => {
        this.successMessage = response;
        this.router.navigate(['/shelf']);
      },
      (error) => {
        this.errorMessage = <any>error;
      }
    )
  }

}
