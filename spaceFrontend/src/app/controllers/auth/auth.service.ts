import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environment/environment';
import { Observable, catchError, of } from 'rxjs';
import { LoginResponse } from '../../models/loginResponse/login-response';
import { ErrorResponse } from '../../models/errorResponse/error-response';
import { LoginRequest } from '../../models/loginRequest/login-request';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private API = '';
  constructor(private http: HttpClient, private cookieService: CookieService) {
    this.API = environment.apiUrl + '/rest/auth/';
  }

  private _loginRequest!: LoginRequest;
  private _loginResponse!: LoginResponse;

  private headersProvider(token: string) {
    const headers = new HttpHeaders({
      Authorization: `Bearer ${token}`,
    });
    return headers;
  }

  public login(): Observable<LoginResponse | ErrorResponse> {
    return this.http.post<LoginResponse | ErrorResponse>(
      this.API + 'login',
      this.loginRequest
    );
  }

  public update(passwordChanged: boolean): Observable<string> {
    const headers = this.headersProvider(this.retrieveUser().token);
    return this.http.put<string>(
      this.API + passwordChanged,
      this.retrieveUser().user,
      {
        headers,
      }
    );
  }

  public storeUser() {
    this.cookieService.set('loginResponse', JSON.stringify(this.loginResponse));
  }

  public retrieveUser(): LoginResponse {
    const storedLoginResponse = this.cookieService.get('loginResponse');
    if (storedLoginResponse) {
      const loginResponse: LoginResponse = JSON.parse(storedLoginResponse);
      return loginResponse;
    }
    return new LoginResponse();
  }

  public deleteUser() {
    this.cookieService.delete('loginResponse', '/');
    this.cookieService.delete('loginResponse');
    console.log(this.retrieveUser());
  }

  public updatePassword(password: string) {
    this.loginResponse.user.password = password;
    const updatedCookie = JSON.stringify(this.loginResponse);
    this.cookieService.set('loginResponse', updatedCookie);
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
}
