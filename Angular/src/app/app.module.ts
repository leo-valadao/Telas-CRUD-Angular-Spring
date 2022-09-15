import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AngularMaterialModule } from './shared/angular-material/angular-material.module';
import { HeaderModule } from './header/header.module';
import { FooterModule } from './footer/footer.module';
import { TableCustomerModule } from './customer/table-customer/table-customer.module';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    HeaderModule,
    FooterModule,
    TableCustomerModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
