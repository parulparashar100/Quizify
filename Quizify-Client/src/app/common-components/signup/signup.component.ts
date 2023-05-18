import { Component } from '@angular/core';
import { User } from 'src/app/interfaces/user';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  public user: User;
  confirmPwd: string;
  isEqual: boolean = false;

  constructor(private _userService: UserService, private _snackBar: MatSnackBar, private _loginService: LoginService, private _router: Router) {
    this.user = {"id": 0, "firstName": '', "lastName": '', "dob": '', "gender": '', "email": '', "password": '', "status": true, "role": "user"};

    this.confirmPwd = '';
  }

  // firstName: string = '';
  // lastName: string = '';
  // email: string = '';
  // password: string = '';
  // confirmPassword: string = '';
  // gender: string = '';
  // birthdate : string ='';

  checkPassword() {
    if(this.user.password === this.confirmPwd) 
      this.isEqual = true;
    else
      this.isEqual = false;
  }

  signup(): void {
    // Handle signup logic here
    console.log('Signup clicked');
    console.log(this.user);

    if(this.user.firstName.trim().length == 0 || this.user.lastName.trim().length == 0 || this.user.password.trim().length == 0) {
      this._snackBar.open("Fields can not be left blank", "OK", {
        duration: 3000,
        verticalPosition: 'top'
      });
    }
    else if(this.user.gender.length == 0) {
      this._snackBar.open("Please select the gender", "OK", {
        duration: 3000,
        verticalPosition: 'top'
      });
    }
    else if(this.user.dob.length == 0) {
      this._snackBar.open("Please enter date of birth", "OK", {
        duration: 3000,
        verticalPosition: 'top'
      });
    }
    else {
      this._userService.addUser(this.user).subscribe({
      // this._userService.getUserById(2).subscribe({
        next: (data) => {
          // console.log((data as User).id);
          this._loginService.generateToken({"email": this.user.email, "password": this.user.password}).subscribe({
            next: (data)=> {
              console.log((data as {"token": string}).token);
              this._loginService.loginUser((data as {"token": string}).token);
              this._userService.getUserByEmail(this.user.email).subscribe({
                next: (user) => {
                  this._loginService.setUserDetail(user);
                  this._router.navigateByUrl("/user-dashboard");
                },
                error: (e)=> {
                  console.log("Unable to fetch user details");
                }
              });
            },
            error: (err)=> {
              console.log(err);
              this._snackBar.open("Encountered Some Problem", "OK", {
                duration: 3000,
                verticalPosition: 'top'
              });
            }
          });
          // localStorage.setItem("USERID", (data as User).id.toString());
          this._snackBar.open("SignUp Successfull", "OK", {
            duration: 4000,
            verticalPosition: 'top'
          });
        }, 
        error: (err) => {
            console.log(err);
            this._snackBar.open("User already exist", "OK", {
            duration: 4000,
            verticalPosition: 'top'
          });
        }
      });
    }

  }

  cancel(): void {
    // Handle cancel logic here
    console.log('Cancel clicked');
  }

}
