import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Category } from 'src/app/interfaces/category';
import { Quiz } from 'src/app/interfaces/quiz';
import { CategoryService } from 'src/app/services/category.service';
import { QuizService } from 'src/app/services/quiz.service';

@Component({
  selector: 'app-add-quiz',
  templateUrl: './add-quiz.component.html',
  styleUrls: ['./add-quiz.component.css']
})
export class AddQuizComponent {

  quiz: Quiz;
  categories: any;

  constructor(private _quizService: QuizService, private _snackBar: MatSnackBar, private _categoryService: CategoryService) {
    this.quiz = {"id": 0, "title": '', "description": '', "maxMarks": 0,
      "numberOfQuestions": 0,
      "isActive": true,
      "categoryId": 0};
  }

  ngOnInit() {
    this.getCategories();
  }

  getCategories() {
    this._categoryService.getAllCategory().subscribe({
      next: (data)=> {
        this.categories = data;
      },
      error: (err)=> {
        console.log(err);
      }
    });
  }

  addQuiz(){
    this._quizService.addQuiz(this.quiz).subscribe({
      next: (data)=> {
        this._snackBar.open("Quiz Added Successfully", "OK", {
          duration: 3000,
          verticalPosition: 'top'
        });
        this.quiz = {"id": 0, "title": '', "description": '', "maxMarks": 0,
        "numberOfQuestions": 0,
        "isActive": true,
        "categoryId": 0};
      },
      error: (err)=> {
        this._snackBar.open("Error Encountered", "OK", {
          duration: 3000,
          verticalPosition: 'top'
        });
      }
    });
  }

}
