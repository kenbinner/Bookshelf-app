import { Injectable } from "@angular/core";
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Book } from "../../models/book";
import { environment } from "../../../environments/environment";
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
    providedIn:'root'
})
export class AddBookService {
    constructor(private http: HttpClient) {

    }

    addBook(book: Book): Observable<string> {
        const url = environment.APIUrl + '/addBook/' + book.customer;

        return this.http.post<string>(url, book)
        .pipe(catchError(this.handleError));

    }

    addImage(imageData: FormData, customer: number): Observable<any> {
      const url = environment.APIUrl + '/addImage/' + customer;

      return this.http.post<string>(url, imageData)
      .pipe(catchError(this.handleError));

  }

    private handleError(err: HttpErrorResponse) {
        console.log(err)
        let errMsg:string='';
        if (err.error instanceof Error) {   
            errMsg=err.error.message;
            console.log(errMsg)
        }
         else if(typeof err.error === 'string'){
            errMsg=JSON.parse(err.error).message
        }
        else {
           if(err.status==0){ 
               errMsg="A connection to back end can not be established.";
           }else{
               errMsg=err.error.message;
           }
         }
            return throwError(errMsg);
    }
}