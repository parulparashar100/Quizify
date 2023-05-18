import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent {

  userName: any;

  constructor(private _loginService: LoginService, private _router: Router) {
  
  }

  ngOnInit(): void {
    this.userName = this._loginService.getUserDetails().firstName;
  }

  logout(){
    this._loginService.logout();
    this._router.navigate(['login']);
  }

}
