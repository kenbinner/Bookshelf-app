import { Book } from "./book";

export class Customer{
    customerId: number;
    name: string;
    email: string;
    password: string;
    bookList: Book[];
}