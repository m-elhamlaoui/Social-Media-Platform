import {Friend} from "../friend/friend";

export class LoginResponse {
  public token!: string;
  public type!: string
  public id!: number;
  public username!: string;
  public email!: string;
  public firstName!: string;
  public lastName!: string;
  public birthDate!: Date;
  public createdAt!: Date;
  public phoneNumber!: string;
  public bio!: string;
  public friends!: Array<Friend>
  public enabled!: boolean;
  public roles!: Array<string>;
}
