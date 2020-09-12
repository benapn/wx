import {
  AfterViewInit, Component, EventEmitter, HostListener, OnDestroy, OnInit, Output,
  ViewChild
} from "@angular/core";
import {MdSidenav} from "@angular/material";
import {Subscription} from "rxjs/Subscription";

@Component({
  selector: 'side-nav',
  templateUrl: './sidenav.component.html',
  styleUrls: ['./sidenav.component.scss']
})
export class SidenavComponent implements AfterViewInit, OnDestroy {
  @ViewChild('sidenav') public sideNav: MdSidenav;
  @Output('is-opening') opening = new EventEmitter<boolean>();
  isOpening: boolean;
  subOpenStart: Subscription;
  subCloseStart: Subscription;
  sideNameItems: object[] = [
    { name: 'Live', link: '/live' }
    , { name: 'Records', link: '/records' }
    , { name: 'History', link: '/history' }
  ];

  ngAfterViewInit(): void {
    this.subOpenStart  = this.sideNav.onOpenStart.subscribe(() => {
      this.opening.emit(true);
    });
    this.subCloseStart = this.sideNav.onCloseStart.subscribe(() => {
      this.opening.emit(false);
    });
  }

  ngOnDestroy(): void {
    this.subOpenStart.unsubscribe();
    this.subCloseStart.unsubscribe();
  }

}
