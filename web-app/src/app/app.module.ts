import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from "@angular/router";
import { BrowserModule } from '@angular/platform-browser';
import {
  MD_RIPPLE_GLOBAL_OPTIONS, MdButtonModule, MdCheckboxModule, MdSnackBarModule,
  RippleGlobalOptions, MdTooltipModule, MdSidenavModule, MdToolbarModule,
  MdIconModule, MdMenuModule, MdCardModule, MdGridListModule, MdListModule,
  MdProgressSpinnerModule, MdCommonModule
} from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import 'hammerjs';

import { AppComponent } from './app.component';
import { LiveComponent } from "./live/live.component";
import {SidenavComponent} from "./sidenav/sidenav.component";
import { RecordsComponent } from './records/records.component';


const globalRippleConfig: RippleGlobalOptions = {
  disabled: true,
  baseSpeedFactor: 1.5
};
const appRouting: Routes = [
   { path: 'live', component: LiveComponent }
  ,{ path: '', redirectTo: '/live', pathMatch: 'full' }
];

@NgModule({
  declarations: [
    AppComponent,
    LiveComponent,
    SidenavComponent,
    RecordsComponent
  ],
  imports: [
    BrowserModule, BrowserAnimationsModule,
    RouterModule.forRoot(appRouting), MdCommonModule,
    MdMenuModule, MdGridListModule, MdListModule,
    MdIconModule, MdCardModule, MdProgressSpinnerModule,
    MdSidenavModule, MdToolbarModule,
    MdButtonModule, MdCheckboxModule,
    MdSnackBarModule, MdTooltipModule
  ],
  providers: [{provide: MD_RIPPLE_GLOBAL_OPTIONS, useValue: globalRippleConfig}],
  bootstrap: [AppComponent]
})
export class AppModule { }
