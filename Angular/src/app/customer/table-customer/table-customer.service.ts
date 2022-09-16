import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from './customer';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TableCustomerService {
  // Address of the Customer API (The File "Angular/proxy.conf.js" is Necessary for Consuming the API,
  // Because the Back-End's API Server is in "http://localhost:8080/",
  // WIthout it Angular Would Consume the API in "http://localhost:4200", wich is the Front-End Address)
  private readonly API = '/api/v1/customer/';

  // Constructor of the Customers's Table Service
  constructor(private httpClient: HttpClient) {}

  // Method that Consumes the API to Get All the Customers
  getAllCustomers() {
    return this.httpClient
      .get<Customer[]>(this.API)
      .pipe(tap((customer) => console.log(customer)));
  }

  // Method that Consumes the API do Get a Single Customer
  GetCustomer(id: number) {
    return this.httpClient.get<Customer>(this.API + id);
  }

  // Method that Consumes the API to Add a New Customer
  saveCustomer(customer: Customer) {
    return this.httpClient.post<Customer>(this.API, customer);
  }

  // Method that Consumes the API to Edit a Existing Customer
  updateCustomer(customer: Customer, id: number) {
    customer.id = id;
    return this.httpClient.put<Customer>(this.API, customer);
  }

  // Method that Consumes the API to Delete a Customer
  deleteCustomer(id: number) {
    return this.httpClient.delete<Customer>(this.API + id);
  }
}
