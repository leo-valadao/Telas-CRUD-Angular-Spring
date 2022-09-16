import { Component, Inject, Injectable, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Customer } from '../table-customer/customer';
import { TableCustomerService } from '../table-customer/table-customer.service';
import { ErrorComponent } from 'src/app/shared/error/error.component';

@Component({
  selector: 'app-form-customer',
  templateUrl: './form-customer.component.html',
  styleUrls: ['./form-customer.component.scss'],
})
export class FormCustomerComponent implements OnInit {
  // Customer's Form
  public formCustomer: FormGroup;

  // Check if the Customer is Being Edited or Created
  private isBeingEdit: boolean;

  // Customer's Form's Constructor
  constructor(
    @Inject(MAT_DIALOG_DATA) private customer: Customer,
    private formBuilder: FormBuilder,
    private tableCustomerService: TableCustomerService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar
  ) {
    // Checks if the Customer is Null or Undefined (If it is Not, that Means that the Edit Button Was the One Used For Opening the Form, Else it Was the Add Button)
    console.log(customer);
    if (this.customer != (null || undefined)) {
      // Fills the Form With the Customer to be Edited
      this.formCustomer = this.formBuilder.group({
        name: [this.customer.name, Validators.required],
        email: [this.customer.email, Validators.required],
        birthDate: [this.customer.birthDate],
      });
      this.isBeingEdit = true;
    } else {
      // Starts the Form Empty for a New Customer
      this.formCustomer = this.formBuilder.group({
        name: [null, Validators.required],
        email: [null, Validators.required],
        birthDate: [null],
      });
      this.isBeingEdit = false;
    }
  }

  ngOnInit(): void {}

  // Method that Shows a Snackbar With a Message of Success
  onSucess() {
    this.dialog.closeAll();
    this.snackBar.open('Customer Successfully Saved!', 'OK', {
      duration: 5000,
    });
    this.dialog.closeAll();
  }

  // Method that Shows a Error on an Angular Dialog Message Box
  onError(errorMsg: string) {
    this.dialog.open(ErrorComponent, { data: errorMsg });
  }

  // Method that Submits the Customer to be Saved or Edited
  onSubmit() {
    console.log('ON SUBMIT: ' + this.isBeingEdit);
    if (this.isBeingEdit == true) {
      let updatedCustomer: Customer = this.formCustomer.value;
      updatedCustomer.id = this.customer.id;
      this.updateCustomer(this.formCustomer.value);
    } else {
      this.saveCustomer();
    }
  }

  // Method to Close All Dialogs Boxes
  onCancel() {
    this.dialog.closeAll();
  }

  // Private Method to Save The Customer
  private saveCustomer() {
    this.tableCustomerService.saveCustomer(this.formCustomer.value).subscribe({
      next: (v) => console.log(v),
      complete: () => this.onSucess(),
      error: (e) => {
        console.log(e), this.onError('Error Saving Customer!');
      },
    });
  }

  // Private Method to Update The Customer
  private updateCustomer(customer: Customer) {
    this.tableCustomerService
      .updateCustomer(this.formCustomer.value, customer.id)
      .subscribe({
        next: (v) => console.log(v),
        complete: () => this.onSucess(),
        error: (e) => {
          console.log(e), this.onError('Error Updating Customer!');
        },
      });
  }
}
