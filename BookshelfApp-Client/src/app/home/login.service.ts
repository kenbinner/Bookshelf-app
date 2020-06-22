import { Injectable } from "@angular/core";
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Customer } from "../models/Customer";
import { environment } from "../../environments/environment";
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
    providedIn:'root'
})
export class LoginService {
    constructor(private http: HttpClient) {

    }
    login(customer: Customer): Observable<Customer> {
        const url = environment.APIUrl + '/customerLogin';

        return this.http.post<Customer>(url,customer)
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