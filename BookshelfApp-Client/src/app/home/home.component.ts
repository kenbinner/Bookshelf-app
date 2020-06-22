import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from "../models/Customer";
import { LoginValidators } from "../validators/login.validator";
import { LoginService } from "./login.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  customer: Customer;
  loginForm: FormGroup;
  errorMessage: string;
  successMessage: string;
  tryToLogin: boolean = false;

  constructor(private fb: FormBuilder,private loginService: LoginService,
    private router: Router) { }

  ngOnInit() {
    this.customer = new Customer();
    this.createForm();
  }

  createForm() {

    this.loginForm = this.fb.group({
      email: [this.customer.email, [Validators.required, LoginValidators.validateEmailId], null],
      password: [this.customer.password, [Validators.required], null]
    });
  }
  login() {
    this.tryToLogin = true;
    this.errorMessage = null;
    this.successMessage = null;
    this.customer = this.loginForm.value as Customer;
    console.log(this.customer);
    this.loginService.login(this.customer).subscribe(
        (response) => {
            this.customer = response
            sessionStorage.setItem("customer", JSON.stringify(this.customer));
            this.tryToLogin = false;
            this.router.navigate(['/shelf']);
        },
        (error) => {
            this.tryToLogin = false;
            this.errorMessage = <any>error;
        }
    )
}

}
