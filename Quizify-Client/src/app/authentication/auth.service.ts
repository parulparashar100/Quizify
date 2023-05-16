import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  isUserLoggedIn = new BehaviorSubject<boolean>(false);
  isAdmin = new BehaviorSubject<boolean>(false);

  constructor() { }

  getIsUserLoggedIn() {
    return this.isUserLoggedIn.asObservable();
  }

  setIsUserLoggedIn(value: boolean) {
    this.isUserLoggedIn.next(value);
  }

  getIsAdmin() {
    return this.isAdmin.asObservable();
  }

  setIsAdmin(value: boolean) {
    this.isAdmin.next(value);
  }

}
