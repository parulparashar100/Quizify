import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { User } from 'src/app/interfaces/user';
import { LoginService } from 'src/app/services/login.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent {

  email: string = '';
  password: string = '';
  confirmPwd: string = '';
  user: User = {"id": 0, "firstName": '', "lastName": '', "dob": '', "gender": '', "email": '', "password": '', "status": true, "role": ''};

  isEqual: boolean = false;


  constructor(private _loginService: LoginService, private _userService: UserService, private _router: Router, private _snackBar: MatSnackBar) {

  }

  checkPassword() {
    if(this.password === this.confirmPwd) 
      this.isEqual = true;
    else
      this.isEqual = false;
  }

  reset(): void {
    // Handle signup logic here
    
    console.log('Reset clicked');
    
    if(this.password.trim().length == 0) {
      this._snackBar.open("Password can not be left blank", "OK", {
        duration: 3000,
        verticalPosition: 'top'
      });
    }
    else {
      this._userService.getUserByEmail(this.email).subscribe({
        next: (data: any) => {
          this.user = {"id": data.id, "firstName": data.firstName, "lastName": data.lastName, "dob": data.dob, "gender": data.gender, "email": data.email, "password": this.password, "status": data.status, "role": data.role};

          this._userService.updateUser(this.user).subscribe({
            next: (data)=> {
              console.log(data);
              this._snackBar.open("Password Reset Successfull", "OK", {
                duration: 3000,
                verticalPosition: 'top'
              });
              this._router.navigate(['login']);
            },
            error: (err)=> {
              console.log(err);
              this._snackBar.open("Error Encountered. Please Try Again!!", "OK", {
                duration: 3000,
                verticalPosition: 'top'
              });
            }
          });
        },
        error: (e)=> {
          console.log("Unable to fetch user details");
          this._snackBar.open("Incorrect Email Id!!", "OK", {
            duration: 3000,
            verticalPosition: 'top'
          });
        }
      });
    }

  }

}
