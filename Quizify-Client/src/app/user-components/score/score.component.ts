import { Component } from '@angular/core';
import { AttemptService } from 'src/app/services/attempt.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-score',
  templateUrl: './score.component.html',
  styleUrls: ['./score.component.css']
})
export class ScoreComponent {

  scores: any;
  userId: any;

  constructor(private _attemptService: AttemptService, private _loginService: LoginService) {
    this.userId = _loginService.getUserDetails().id;
  }

  ngOnInit(): void {
    this.userId = this._loginService.getUserDetails().id;
    this.getAllScores();
  }

  getAllScores() {
    this._attemptService.getAllattemptsByUserId(this.userId).subscribe({
      next: (data) => {
        console.log(data);
        this.scores = data;
      },
      error: (err) => {
        console.log(err);
      }
    })
  }

}
