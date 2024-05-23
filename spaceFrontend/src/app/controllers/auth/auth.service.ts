import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {environment} from '../../../environment/environment';
import {Observable} from 'rxjs';
import {LoginResponse} from '../../models/loginResponse/login-response';
import {LoginRequest} from '../../models/loginRequest/login-request';
import {CookieService} from 'ngx-cookie-service';
import {SignupRequest} from "../../models/SignupRequest/signup-request";
import {MessageResponse} from "../../models/MessageResponse/message-response";

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private API = '';

  constructor(private http: HttpClient, private cookieService: CookieService) {
    this.API = environment.apiUrl + '/auth/';
  }

  private _loginRequest!: LoginRequest;
  private _loginResponse!: LoginResponse;
  private _signupRequest!: SignupRequest

  private headersProvider(token: string) {
    return new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });
  }

  public login(): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(
      this.API + 'signin',
      this.loginRequest
    );
  }

  public update(): Observable<MessageResponse> {
    return this.http.post<MessageResponse>(
      this.API + 'signup',
      this.signupRequest
    );
  }

  public storeUser() {
    this.cookieService.set('loginResponse', JSON.stringify(this.loginResponse));
  }

  public retrieveUser(): LoginResponse {
    const storedLoginResponse = this.cookieService.get('loginResponse');
    if (storedLoginResponse) {
      return JSON.parse(storedLoginResponse);
    }
    return new LoginResponse();
  }

  public deleteUser() {
    this.cookieService.delete('loginResponse', '/');
    this.cookieService.delete('loginResponse');
    console.log(this.retrieveUser());
  }


  public get loginRequest(): LoginRequest {
    return this._loginRequest;
  }

  public set loginRequest(value: LoginRequest) {
    this._loginRequest = value;
  }

  public get loginResponse(): LoginResponse {
    return this._loginResponse;
  }

  public set loginResponse(value: LoginResponse) {
    this._loginResponse = value;
  }


  get signupRequest(): SignupRequest {
    return this._signupRequest;
  }

  set signupRequest(value: SignupRequest) {
    this._signupRequest = value;
  }
}
