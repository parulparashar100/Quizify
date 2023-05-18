import { Component } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {

  user: any;
  status: string;

  constructor(private _loginService: LoginService) {
    this.user = _loginService.getUserDetails();
    if(this.user.status)
      this.status = "Active";
    else 
      this.status = "Disabled";

  }
  
  printProfile() {
    window.print();
  }

}
