import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private _http: HttpClient) { }

  public getAllUser() {
    return this._http.get("/user/userlist");
  }

  public getUserById(id: number) {
    return this._http.get("/user/userlist/" + id);
  }

  public getUserByEmailAndPassword(email: string, password: string) {
    return this._http.get("/user/userlist/verify/" + email + "/" + password);
  }

  public addUser(user: User) {
    return this._http.post("/user/userlist", user);
  }

  public updateUser(user: User) {
    return this._http.put("/user/userlist", user);
  }

  public deleteUser(id: number) {
    return this._http.delete("/user/userlist/" + id);
  }

}
