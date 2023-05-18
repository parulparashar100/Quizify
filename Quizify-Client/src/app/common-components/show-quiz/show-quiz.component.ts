import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { QuizService } from 'src/app/services/quiz.service';

@Component({
  selector: 'app-show-quiz',
  templateUrl: './show-quiz.component.html',
  styleUrls: ['./show-quiz.component.css']
})
export class ShowQuizComponent {

  quizzes: any;
  isAdmin: boolean = false;
  isUser: boolean = true;

  constructor(private _router: Router, private _quizService: QuizService, public _loginService: LoginService) {
    
  }

  ngOnInit(): void {
    this.setIsAdmin();
    this.getQuizzes();
    console.log(this.quizzes);
  }

  openQuiz() {

  }

  setIsAdmin() {
    if(this._loginService.getUserRole() === "admin") {
      this.isAdmin = true;
      this.isUser = false;
    } else {
      this.isAdmin = false;
      this.isUser = true;
    }
  }

  getQuizzes() {
    this._quizService.getAllQuiz().subscribe({
      next: (data)=> {
        this.quizzes = data;
        console.log("method data :-" + data);
      },
      error: (err)=> {
        console.log(err);
      }
    });
  }

}
