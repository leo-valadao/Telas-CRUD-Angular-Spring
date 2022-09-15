import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-table-customer',
  templateUrl: './table-customer.component.html',
  styleUrls: ['./table-customer.component.scss']
})
export class TableCustomerComponent implements OnInit {

  displayedColumns = ['id', 'name', 'email', 'birthDate'];

  constructor() { }

  ngOnInit(): void {
  }

}
