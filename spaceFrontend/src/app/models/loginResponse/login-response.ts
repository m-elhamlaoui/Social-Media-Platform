import { User } from '../user/user';

export class LoginResponse {
  public token!: string;
  public user!: User;
}