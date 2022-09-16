import { Component, OnInit } from '@angular/core';
import { Customer } from './customer';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialog } from '@angular/material/dialog';
import { catchError, Observable, of } from 'rxjs';
import { TableCustomerService } from './table-customer.service';
import { ErrorComponent } from 'src/app/shared/error/error.component';
import { FormCustomerComponent } from '../form-customer/form-customer.component';

@Component({
  selector: 'app-table-customer',
  templateUrl: './table-customer.component.html',
  styleUrls: ['./table-customer.component.scss'],
})
export class TableCustomerComponent implements OnInit {
  // Inicialization of the List of Customers (Starts with 0 Customer, then the TableCustomerService (as a Parameter of the Constructor) Consumes the API (Method "onLoad()") to Get All the Customers)
  customerList: Observable<Customer[]> = new Observable<Customer[]>();

  // Displayed Columns on the Customers's Table
  displayedColumns = ['id', 'name', 'email', 'birthDate', 'actions'];

  // Constructor of the Customers's Table
  constructor(
    private tableCustomerService: TableCustomerService,
    public dialog: MatDialog,
    private snackBar: MatSnackBar
  ) {
    // Starts the Page Consuming the API to Get All the Customers
    this.onLoad();
  }

  ngOnInit(): void {}

  // Method that Uses the Customers's Table Service to Get All the Customers
  onLoad() {
    this.customerList = this.tableCustomerService.getAllCustomers().pipe(
      catchError((error) => {
        console.log(error);
        this.onError('Error Loading the Customers Table!');
        return of([]);
      })
    );
  }

  // Method that Uses the Customers's Table Service to Add a New Custoemr
  onAdd() {
    this.dialog.open(FormCustomerComponent, { disableClose: true });
  }

  // Method that Uses the Customers's Table Service to Edit a Existing Customer
  onEdit(customer: Customer) {
    this.dialog.open(FormCustomerComponent, {
      disableClose: true,
      data: customer,
    });
  }

  // Method that Deletes a Customer from the Table
  onDelete(id: number) {
    this.tableCustomerService.deleteCustomer(id).subscribe({
      next: (v) => console.log(v),
      complete: () => this.onSucess('Customer Successfully Deleted!'),
      error: (e) => {
        console.log(e), this.onError('Error Deleting Customer!');
      },
    });
    this.onLoad();
  }

  // Method that Shows a Snackbar With a Message of Success
  onSucess(message: string) {
    this.dialog.closeAll();
    this.snackBar.open(message, 'OK', {
      duration: 5000,
    });
    this.onLoad();
  }

  // Method that Shows a Error on an Angular Dialog Message Box
  onError(errorMsg: string) {
    this.dialog.open(ErrorComponent, { data: errorMsg });
  }
}
