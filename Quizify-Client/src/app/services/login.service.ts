import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private _http: HttpClient) { }

  public generateToken(loginData: any) {
    return this._http.post(`${baseUrl}/generate-token`, loginData);
  }

  public loginUser(token: any) {
    localStorage.setItem("token", token);
    return true;
  }

  public isLoggedIn() {
    let tokenStr = localStorage.getItem("token");
    if(tokenStr == undefined || tokenStr == '' || tokenStr == null){
      return false;
    }
    else{
      return true;
    }
  }

  public logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("userid");
    return true;
  }

  public getToken() {
    return localStorage.getItem("token");
  }

  public setUserDetail(user: any) {
    localStorage.setItem("user", JSON.stringify(user));
  }

  public getUserDetails() {
    let userStr = localStorage.getItem("user");
    if(userStr != null) {
      return JSON.parse(userStr);
    }
    else {
      this.logout();
      return null;
    }
  }

  public getUserRole() {
    let user = this.getUserDetails();
    return user.authorities[0].authority;
  }

}
