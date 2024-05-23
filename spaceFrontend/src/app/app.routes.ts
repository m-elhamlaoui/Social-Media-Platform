<<<<<<< HEAD
import {Routes} from '@angular/router';
import {HomeComponent} from './views/home/home.component';
import {LoginComponent} from './views/wide/login/login.component';
import {RegisterComponent} from "./views/wide/register/register.component";

export const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'register',
    component: RegisterComponent,
  },
  {
    path: 'home',
    component: HomeComponent,
  },
];
=======
import { Routes } from '@angular/router';
import { HomeComponent } from './views/home/home.component';
import { LoginComponent } from './views/wide/login/login/login.component';
import { MessageComponent } from './views/message/message/message.component';
import { PostComponent } from './views/post/post/post.component';

export const routes: Routes = [
    {
        path: 'login',
        component: LoginComponent,
      },
      {
        path: 'message',
        component: MessageComponent,
      },
      {
        path: 'home',
        component: HomeComponent,
      },
      {
        path: 'post',
        component: PostComponent,
      },
];
>>>>>>> fb527122b3179f6590f86de0e60489d49e3083d4
