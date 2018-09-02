import {
  MatButtonModule,
  MatCardModule,
  MatCheckboxModule,
  MatIconModule,
  MatListModule,
  MatGridListModule,
  MatMenuModule,
  MatSidenavModule,
  MatToolbarModule
} from '@angular/material';
import { NgModule } from '@angular/core';

let matModules = [
  MatButtonModule,
  MatCheckboxModule,
  MatSidenavModule,
  MatCardModule,
  MatListModule,
  MatGridListModule,
  MatMenuModule,
  MatIconModule,
  MatToolbarModule
];

@NgModule({
  imports: matModules,
  exports: matModules,
})
export class MaterialModule { }
