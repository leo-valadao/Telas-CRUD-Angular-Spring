import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AngularMaterialModule } from './shared/angular-material/angular-material.module';
import { HeaderModule } from './header/header.module';
import { FooterModule } from './footer/footer.module';
import { TableCustomerModule } from './customer/table-customer/table-customer.module';
import { ErrorComponent } from './shared/error/error.component';
import { FormCustomerComponent } from './customer/form-customer/form-customer.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [AppComponent, ErrorComponent, FormCustomerComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    HeaderModule,
    FooterModule,
    TableCustomerModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
