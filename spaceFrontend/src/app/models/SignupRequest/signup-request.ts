export class SignupRequest {
  public username!: string;
  public email!: string;
  public password!: string;
  public firstName!: string;
  public lastName!: string;
  public birthDate!: Date;
  public createdAt!: Date;
  public phoneNumber!: string;
  public role!: Array<string>;
}
