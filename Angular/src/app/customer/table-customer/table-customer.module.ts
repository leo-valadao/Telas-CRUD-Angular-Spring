import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TableCustomerRoutingModule } from './table-customer-routing.module';
import { TableCustomerComponent } from './table-customer.component';
import { AngularMaterialModule } from 'src/app/shared/angular-material/angular-material.module';

@NgModule({
  declarations: [TableCustomerComponent],
  imports: [CommonModule, TableCustomerRoutingModule, AngularMaterialModule],
  exports: [TableCustomerComponent],
})
export class TableCustomerModule {}
