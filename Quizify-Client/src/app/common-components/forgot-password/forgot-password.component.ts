import { Component } from '@angular/core';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent {

  email: string = '';
  password: string = '';

  reset(): void {
    // Handle signup logic here
    console.log('Reset clicked');
  }

}
