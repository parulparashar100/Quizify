import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginData = {
    "email": '',
    "password": ''
  }

  constructor(private _userService: UserService, private router: Router, private _snackBar: MatSnackBar, private _loginService: LoginService, private _router: Router) { }

  login() {
    // Perform login logic here

    if(this.loginData.password.trim().length == 0) {
      this._snackBar.open("Password can not be left blank", "OK", {
        duration: 3000,
        verticalPosition: 'top'
      });
      return;
    }

    //request to server to generate token
    this._loginService.generateToken(this.loginData).subscribe({
      next: (data)=> {
        console.log((data as {"token": string}).token);
        this._loginService.loginUser((data as {"token": string}).token);
        this._userService.getUserByEmail(this.loginData.email).subscribe({
          next: (user) => {
            this._loginService.setUserDetail(user);
            console.log(this._loginService.getUserRole());
            if(this._loginService.getUserRole() === 'admin'){
              this._router.navigateByUrl("/admin-dashboard");
            }
            else{
              this._router.navigateByUrl("/user-dashboard");
            }
          },
          error: (e)=> {
            console.log("Unable to fetch user details");
          }
        });
      },
      error: (err)=> {
        console.log(err);
        this._snackBar.open("Invalid Credentials!!", "OK", {
          duration: 3000,
          verticalPosition: 'top'
        });
      }
    });
  }

}
