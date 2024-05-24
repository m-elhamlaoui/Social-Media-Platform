import {AuthService} from './../../../controllers/auth/auth.service';
import {Router} from '@angular/router';
import {ButtonModule} from 'primeng/button';
import {CommonModule} from '@angular/common';
import {Component} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {CardModule} from 'primeng/card';

@Component({
  selector: 'app-unauthorized',
  standalone: true,
  imports: [CommonModule, FormsModule, CardModule, ButtonModule],
  templateUrl: './unauthorized.component.html',
  styleUrl: './unauthorized.component.css',
})
export class UnauthorizedComponent {
  constructor(private router: Router, private authService: AuthService) {
  }

  back() {
    const username = this.authService.retrieveUser().username
    if (username === undefined || username === null || username === '')
      this.router.navigate(['login']);
    else this.router.navigate(['stage/list']);
  }
}
