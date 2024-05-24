import {Component, OnInit} from '@angular/core';
import {ButtonModule} from "primeng/button";
import {CardModule} from "primeng/card";
import {InputGroupAddonModule} from "primeng/inputgroupaddon";
import {InputGroupModule} from "primeng/inputgroup";
import {InputTextModule} from "primeng/inputtext";
import {PasswordModule} from "primeng/password";
import {MessageService} from "primeng/api";
import {Router} from "@angular/router";
import {AuthService} from "../../../controllers/auth/auth.service";
import {SignupRequest} from "../../../models/SignupRequest/signup-request";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-register',
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
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent implements OnInit {
  public validateUsername!: boolean;
  public validateEmail!: boolean;
  public validateFirstName!: boolean;
  public validateLastName!: boolean;
  public validateBirthDate!: boolean;
  public validatePhoneNumber!: boolean;
  public validatePassword!: boolean;

  constructor(
    private router: Router,
    private messageService: MessageService,
    private authService: AuthService
  ) {
  }

  ngOnInit() {
    this.validateUsername = true;
    this.validateEmail = true;
    this.validateFirstName = true;
    this.validateLastName = true;
    this.validateBirthDate = true;
    this.validatePhoneNumber = true;
    this.validatePassword = true;
    this.signupRequest = new SignupRequest();
  }

  register(): void {
    if (this.validateForm()) {
      this.signupRequest.role = new Array<string>()
      this.signupRequest.role.push('user')
      this.authService.update().subscribe({
        next: (data) => {
          this.messageService.add({
            severity: 'success',
            summary: 'Success',
            detail: "Account created",
            life: 3000,
          });
          this.router.navigate(['login']);
        },
        error: (e) => {
          this.messageService.add({
            severity: 'error',
            summary: 'Error',
            detail: "The username or email already exists",
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
      this.signupRequest.username === undefined ||
      this.signupRequest.username === ''
    ) {
      this.validateUsername = false;
      counter++;
    } else this.validateUsername = true;
    if (
      this.signupRequest.email === undefined ||
      this.signupRequest.email === ''
    ) {
      this.validateEmail = false;
      counter++;
    } else this.validateEmail = true;
    if (
      this.signupRequest.firstName === undefined ||
      this.signupRequest.firstName === ''
    ) {
      this.validateFirstName = false;
      counter++;
    } else this.validateFirstName = true;
    if (
      this.signupRequest.lastName === undefined ||
      this.signupRequest.lastName === ''
    ) {
      this.validateLastName = false;
      counter++;
    } else this.validateLastName = true;
    if (
      this.signupRequest.birthDate === undefined ||
      this.signupRequest.birthDate.toString() === ''
    ) {
      this.validateBirthDate = false;
      counter++;
    } else this.validateBirthDate = true;
    if (
      this.signupRequest.phoneNumber === undefined ||
      this.signupRequest.phoneNumber === ''
    ) {
      this.validatePhoneNumber = false;
      counter++;
    } else this.validatePhoneNumber = true;
    if (
      this.signupRequest.password === undefined ||
      this.signupRequest.password === ''
    ) {
      this.validatePassword = false;
      counter++;
    } else this.validatePassword = true;
    return counter === 0;
  }

  login() {
    this.router.navigate(['login']);
  }

  get signupRequest(): SignupRequest {
    return this.authService.signupRequest;
  }

  set signupRequest(value: SignupRequest) {
    this.authService.signupRequest = value;
  }
}
