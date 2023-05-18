import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent {

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
