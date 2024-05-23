import { AuthService } from './controllers/auth/auth.service';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterOutlet } from '@angular/router';
import {
  ConfirmationService,
  MessageService,
  PrimeNGConfig,
} from 'primeng/api';
import { HeaderComponent } from './views/wide/header/header.component';
import { ToastModule } from 'primeng/toast';
import { ConfirmDialogModule } from 'primeng/confirmdialog';

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
export class AppComponent {
  title = 'Space';
  constructor(
    private primengConfig: PrimeNGConfig,
    private router: Router,
    private authService: AuthService
  ) {
    this.primengConfig.ripple = true;
  }

  ngOnInit(): void {
    if (this.authService.retrieveUser().user === undefined)
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
