import {Component, HostListener, ViewChild} from '@angular/core';
import {MdSidenav, MdSidenavToggleResult} from "@angular/material";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  @ViewChild('mySidenav') mySidenav: any;
  title: string = 'Wx';
  sidenavState: boolean = false;

  toggle(): void {
    this.mySidenav.sideNav.toggle();
  }

  setSidenavState(event): void {
    this.sidenavState = event;
  }
}
