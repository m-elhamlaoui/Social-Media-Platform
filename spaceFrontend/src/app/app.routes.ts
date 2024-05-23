import { Routes } from '@angular/router';
import { HomeComponent } from './views/home/home.component';
import { LoginComponent } from './views/wide/login/login/login.component';

export const routes: Routes = [
    {
        path: 'login',
        component: LoginComponent,
      },
      {
        path: 'home',
        component: HomeComponent,
      },
];