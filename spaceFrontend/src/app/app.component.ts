import { AuthService } from './controllers/auth/auth.service';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterOutlet } from '@angular/router';

import { InputGroupModule } from 'primeng/inputgroup';
import { InputGroupAddonModule } from 'primeng/inputgroupaddon';
import {
  ConfirmationService,
  MessageService,
  PrimeNGConfig,
} from 'primeng/api';
import { HeaderComponent } from './views/wide/header/header.component';
import { ToastModule } from 'primeng/toast';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { SideMenuComponent } from './views/wide/side-menu/side-menu.component';

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
    InputGroupAddonModule
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
  providers: [MessageService, ConfirmationService],
})
export class AppComponent {
  title = 'Space Explorers';
  constructor(
    private primengConfig: PrimeNGConfig,
    private router: Router,
    private authService: AuthService
  ) {
    this.primengConfig.ripple = true;
  }

  ngOnInit(): void {
    if (this.authService.retrieveUser().user === undefined)
      this.router.navigate(['home']);
  }

  ngOnDestroy(): void {
    this.authService.deleteUser();
  }

  checkLink(): boolean {
    if (
      this.router.url.includes('login') ||
      this.router.url.includes('unauthorized')
    )
      return false;
    else return true;
  }
}
