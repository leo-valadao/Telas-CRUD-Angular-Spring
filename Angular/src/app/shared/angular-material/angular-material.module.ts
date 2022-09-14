import { NgModule } from '@angular/core';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';

@NgModule({
  exports: [MatToolbarModule, MatIconModule, MatInputModule],
})
export class AngularMaterialModule {}
