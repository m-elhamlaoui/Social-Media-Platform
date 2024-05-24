import {AuthService} from './../../../controllers/auth/auth.service';
import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {MenuItem} from 'primeng/api';
import {PanelMenuModule} from 'primeng/panelmenu';

@Component({
  selector: 'app-side-menu',
  standalone: true,
  imports: [PanelMenuModule],
  templateUrl: './side-menu.component.html',
  styleUrls: ['./side-menu.component.css'],
})
export class SideMenuComponent implements OnInit {
  items: MenuItem[] = [];

  constructor(private router: Router, private authService: AuthService) {
  }

  ngOnInit() {
    this.items = [
      {label: 'Home', icon: 'pi pi-fw pi-home', command: () => this.router.navigate(['home']),},
      {label: 'Explore', icon: 'pi pi-fw pi-globe', command: () => this.router.navigate(['explore']),},
      {label: 'Notifications', icon: 'pi pi-fw pi-bell', command: () => this.router.navigate(['notification']),},
      {label: 'Messages', icon: 'pi pi-fw pi-envelope', command: () => this.router.navigate(['message']),},
      {label: 'Friends', icon: 'pi pi-fw pi-users', command: () => this.router.navigate(['friend']),},
      {label: 'Profile', icon: 'pi pi-fw pi-user-edit', command: () => this.router.navigate(['home']),},
      {label: 'More', icon: 'pi pi-fw pi-ellipsis-h', command: () => this.router.navigate(['home']),},
      {
        label: 'Log Out',
        icon: 'pi pi-fw pi-power-off',
        command: () => {
          this.authService.deleteUser()
          this.router.navigate(['login'])
        },
      },
    ];
  }
}
