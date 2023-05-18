import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginService } from '../services/login.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private _loginService: LoginService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // Get the JWT token
    const token = this._loginService.getToken();
    let authRequest = request;
    // If a token is available, add it to the Authorization header
    if (token != null) {
        authRequest = authRequest.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`
        }
      });
    }

    // Pass the modified request to the next interceptor or the HTTP handler
    return next.handle(authRequest);
  }
}

export const authInterceptorProviders = [{
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
}]