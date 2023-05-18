import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-show-questions',
  templateUrl: './show-questions.component.html',
  styleUrls: ['./show-questions.component.css']
})
export class ShowQuestionsComponent {

  quizId: any;

  questions: Question[] = [
    {
      questionName: 'Which city is the capital of India?',
      options: ['Delhi', 'Mumbai', 'Bangalore'],
      editing: false,
      correctAnswer: ''
    },
    {
      questionName: 'When did India win the ODI World Cup?',
      options: ['1983', '2011', '2005'],
      editing: false,
      correctAnswer: ''
    }
  ];

  constructor(private _route: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.quizId = this._route.snapshot.paramMap.get('id');
  }

  editQuestion(question: Question) {
    // Toggle editing property of the question
    question.editing = !question.editing;
  }

  deleteQuestion(question: Question) {
    // Find the index of the question in the array
    const index = this.questions.indexOf(question);
    if (index !== -1) {
      // Remove the question from the array
      this.questions.splice(index, 1);
    }
  }
}

interface Question {
  questionName: string;
  options: string[];
  editing: boolean;
  correctAnswer: string;
}
