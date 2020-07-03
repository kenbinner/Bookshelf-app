import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AddBookService } from './add-book.service';
import { Customer } from "../../models/Customer";
import { Book } from "../../models/book";

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {
  customer: Customer;
  addBookForm: FormGroup;
  newBook: Book;
  image: File;

  errorMessage: string;
  successMessage: string;
  constructor(private fb: FormBuilder, private addBookService: AddBookService) { }

  ngOnInit() {
    this.customer = JSON.parse(sessionStorage.getItem("customer"));
    this.newBook = new Book;
    this.createAddBookForm();
  }

  onFileChanged(event) {
    this.newBook.image = event.target.files[0];
  }

//   getBase64(event) {
//     let file = event.target.files[0];
//     let reader = new FileReader();
//     reader.readAsDataURL(file);
//     reader.onload = function () {
//       console.log(reader.result);
//     };
//     reader.onerror = function (error) {
//       console.log('Error: ', error);
//     };
//     this.newBook.image = reader.result;
//  }

  createAddBookForm() {
    this.addBookForm = this.fb.group({
      title: [this.newBook.title, [Validators.required]],
      author: [this.newBook.author],
      isbn: [this.newBook.isbn],
      status: [this.newBook.status],
      rating: [this.newBook.rating],
      comments: [this.newBook.comments],
      image: [this.newBook.image]
    });
  }

  addBook(){
    this.errorMessage = null;
    this.successMessage = null;
    this.newBook = this.addBookForm.value as Book;
    this.newBook.customer = this.customer.customerId;
    // this.image = this.newBook.image;
    // this.newBook.image = null;
    console.log(this.newBook);
    this.addBookService.addBook(this.newBook).subscribe(
      (response) => {
        this.successMessage = response;
      },
      (error) => {
        this.errorMessage = <any>error;
      }
    )
    console.log(this.errorMessage);

    // const addImageData = new FormData();
    // addImageData.append('imageFile', this.image, this.image.name);
    // this.addBookService.addImage(addImageData, this.customer.customerId).subscribe(
    //   (response) => {
    //     this.successMessage = response
    //   },
    //   (error) => {
    //     this.errorMessage = <any>error;
    //   }
    // )
  }
}
