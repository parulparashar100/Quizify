import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  emailId: string = '';
  pwd: string = '';

  constructor(private _userService: UserService, private router: Router) { }

  login() {
    // Perform login logic here
    this._userService.getUserByEmailAndPassword(this.emailId, this.pwd).subscribe({
      next: (data)=> {console.log(data)},
      error: (err)=> {console.log(err.error)}
    });
  }

}
