import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/authentication/auth.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor(public _loginService: LoginService, private _router: Router) {

  }

  ngOnInit() {

  }

  logout(){
    this._loginService.logout();
    this._router.navigate(['login']);
  }

}
