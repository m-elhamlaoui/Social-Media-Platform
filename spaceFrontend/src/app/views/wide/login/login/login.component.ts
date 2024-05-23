import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { InputGroupModule } from 'primeng/inputgroup';
import { InputGroupAddonModule } from 'primeng/inputgroupaddon';
import { ButtonModule } from 'primeng/button';
import { CardModule } from 'primeng/card';
import { PasswordModule } from 'primeng/password';
import { FormsModule } from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { MessageService } from 'primeng/api';
import { AuthService } from '../../../../controllers/auth/auth.service';
import { LoginRequest } from '../../../../models/loginRequest/login-request';
import { LoginResponse } from '../../../../models/loginResponse/login-response';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    CardModule,
    InputTextModule,
    InputGroupModule,
    InputGroupAddonModule,
    ButtonModule,
    PasswordModule,
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent implements OnInit {
  public validateEmail!: boolean;
  public validatePassword!: boolean;
  public validateCredentials!: boolean;

  constructor(
    private router: Router,
    private messageService: MessageService,
    private authService: AuthService
  ) {}

  ngOnInit() {
    this.validateEmail = true;
    this.validatePassword = true;
    this.validateCredentials = true;
    this.loginRequest = new LoginRequest();
  }

  login(): void {
    if (this.validateForm()) {
      this.authService.login().subscribe({
        next: (data) => {
          this.loginResponse = data as LoginResponse;
          this.authService.storeUser();
          this.router.navigate(['home']);
        },
        error: (e) => console.log(e),
      });
    } else {
      this.messageService.add({
        severity: 'error',
        summary: 'Échec',
        detail: 'Veuillez remplir tous les champs obligatoires',
        life: 3000,
      });
    }
  }

  private validateForm(): boolean {
    let counter = 0;
    if (
      this.loginRequest.email === undefined ||
      this.loginRequest.email === ''
    ) {
      this.validateEmail = false;
      counter++;
    } else this.validateEmail = true;
    if (
      this.loginRequest.password === undefined ||
      this.loginRequest.password === ''
    ) {
      this.validatePassword = false;
      counter++;
    } else this.validatePassword = true;
    if (counter === 0) return true;
    else return false;
  }

  public get loginRequest(): LoginRequest {
    return this.authService.loginRequest;
  }
  public set loginRequest(value: LoginRequest) {
    this.authService.loginRequest = value;
  }
  public get loginResponse(): LoginResponse {
    return this.authService.loginResponse;
  }
  public set loginResponse(value: LoginResponse) {
    this.authService.loginResponse = value;
  }
}