import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  isAdmin: boolean = false;

  constructor(public _loginService: LoginService, private _router: Router) {

  }

  ngOnInit(): void {
    this.setIsAdmin();
  }

  setIsAdmin() {
    if(this._loginService.getUserRole() === "admin") {
      this.isAdmin = true;
    } else {
      this.isAdmin = false;
    }
  }

  startQuiz() {
    if(this._loginService.isLoggedIn())
      // this._router.navigate(['/category']);
      this._router.navigate(['/user-dashboard/show-quiz']);
    
    else 
      this._router.navigate(['/login']);
    
  }

}
