import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../interfaces/user';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private _http: HttpClient) { }

  public getAllUser() {
    return this._http.get(`${baseUrl}/user/userlist`);
  }

  public getUserById(id: number) {
    return this._http.get(`${baseUrl}/user/userlist/` + id);
  }

  public getUserByEmail(email: string) {
    return this._http.get(`${baseUrl}/user/userlist/email/` + email);
  }

  public addUser(user: User) {
    return this._http.post(`${baseUrl}/user/userlist`, user);
  }

  public updateUser(user: User) {
    return this._http.put(`${baseUrl}/user/userlist`, user);
  }

  public deleteUser(id: number) {
    return this._http.delete(`${baseUrl}/user/userlist/` + id);
  }

}
