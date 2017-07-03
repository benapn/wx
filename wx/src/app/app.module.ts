import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {
  MD_RIPPLE_GLOBAL_OPTIONS, MdButtonModule, MdCheckboxModule, MdSnackBarModule,
  RippleGlobalOptions, MdTooltipModule
} from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';

import 'hammerjs';

const globalRippleConfig: RippleGlobalOptions = {
  disabled: true,
  baseSpeedFactor: 1.5
}

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MdButtonModule,
    MdCheckboxModule,
    MdSnackBarModule,
    MdTooltipModule
  ],
  providers: [{provide: MD_RIPPLE_GLOBAL_OPTIONS, useValue: globalRippleConfig}],
  bootstrap: [AppComponent]
})
export class AppModule { }
