import {Routes} from '@angular/router';
import {HomeComponent} from './views/home/home.component';
import {MessageComponent} from './views/message/message/message.component';
import {PostComponent} from './views/post/post/post.component';
import {RegisterComponent} from "./views/wide/register/register.component";
import {LoginComponent} from "./views/wide/login/login.component";

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
  }
]
