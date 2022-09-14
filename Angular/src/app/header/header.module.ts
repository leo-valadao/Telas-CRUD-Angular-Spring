import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HeaderRoutingModule } from './header-routing.module';
import { HeaderComponent } from './header.component';
import { AngularMaterialModule } from '../shared/angular-material/angular-material.module';

@NgModule({
  declarations: [HeaderComponent],
  imports: [CommonModule, HeaderRoutingModule, AngularMaterialModule],
  exports: [HeaderComponent],
})
export class HeaderModule {}
