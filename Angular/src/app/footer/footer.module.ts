import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FooterRoutingModule } from './footer-routing.module';
import { FooterComponent } from './footer.component';
import { AngularMaterialModule } from '../shared/angular-material/angular-material.module';

@NgModule({
  declarations: [FooterComponent],
  imports: [CommonModule, FooterRoutingModule, AngularMaterialModule],
  exports: [FooterComponent],
})
export class FooterModule {}
