import {AuthService} from './controllers/auth/auth.service';
import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Router, RouterOutlet} from '@angular/router';
import {ConfirmationService, MessageService, PrimeNGConfig,} from 'primeng/api';
import {HeaderComponent} from './views/wide/header/header.component';
import {ToastModule} from 'primeng/toast';
import {ConfirmDialogModule} from 'primeng/confirmdialog';
import {InputGroupModule} from "primeng/inputgroup";
import {InputGroupAddonModule} from "primeng/inputgroupaddon";
import {SideMenuComponent} from "./views/wide/side-menu/side-menu.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    HeaderComponent,
    SideMenuComponent,
    ToastModule,
    ConfirmDialogModule,
    InputGroupModule,
    InputGroupAddonModule,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  providers: [MessageService, ConfirmationService],
})
export class AppComponent implements OnInit {
  title = 'Space';

  constructor(
    private primengConfig: PrimeNGConfig,
    private router: Router,
    private authService: AuthService
  ) {
    this.primengConfig.ripple = true;
  }

  ngOnInit(): void {
    const username = this.authService.retrieveUser().username
    if (username === undefined || username === null || username === '')
      this.router.navigate(['login']);
  }

  checkLink(): boolean {
    if (
      this.router.url.includes('login') ||
      this.router.url.includes('register') ||
      this.router.url.includes('unauthorized')
    )
      return false;
    else return true;
  }
}
