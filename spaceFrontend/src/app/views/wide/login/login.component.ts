import {CommonModule} from '@angular/common';
import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {InputGroupModule} from 'primeng/inputgroup';
import {InputGroupAddonModule} from 'primeng/inputgroupaddon';
import {ButtonModule} from 'primeng/button';
import {CardModule} from 'primeng/card';
import {PasswordModule} from 'primeng/password';
import {FormsModule} from '@angular/forms';
import {InputTextModule} from 'primeng/inputtext';
import {MessageService} from 'primeng/api';
import {AuthService} from '../../../controllers/auth/auth.service';
import {LoginRequest} from '../../../models/loginRequest/login-request';
import {LoginResponse} from '../../../models/loginResponse/login-response';

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
  public validateUsername!: boolean;
  public validatePassword!: boolean;

  constructor(
    private router: Router,
    private messageService: MessageService,
    private authService: AuthService
  ) {
  }

  ngOnInit() {
    this.validateUsername = true;
    this.validatePassword = true;
    this.loginRequest = new LoginRequest();
  }

  login(): void {
    if (this.validateForm()) {
      this.authService.login().subscribe({
        next: (data) => {
          this.loginResponse = data as LoginResponse;
          this.authService.storeUser();
          this.messageService.add({
            severity: 'success',
            summary: 'Success',
            detail: "Login successful",
            life: 3000,
          });
          this.router.navigate(['home']);
        },
        error: (e) => {
          this.messageService.add({
            severity: 'error',
            summary: 'Error',
            detail: "The username or password is incorrect",
            life: 3000,
          });
        },
      });
    } else {
      this.messageService.add({
        severity: 'error',
        summary: 'Error',
        detail: 'Please fill in all mandatory fields',
        life: 3000,
      });
    }
  }

  private validateForm(): boolean {
    let counter = 0;
    if (
      this.loginRequest.username === undefined ||
      this.loginRequest.username === ''
    ) {
      this.validateUsername = false;
      counter++;
    } else this.validateUsername = true;
    if (
      this.loginRequest.password === undefined ||
      this.loginRequest.password === ''
    ) {
      this.validatePassword = false;
      counter++;
    } else this.validatePassword = true;
    return counter === 0;
  }

  register() {
    this.router.navigate(['register']);
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
