import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
import { Quiz } from '../interfaces/quiz';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  constructor(private _http: HttpClient) { }

  public getAllQuiz() {
    return this._http.get(`${baseUrl}/quiz/quizlist`);
  }

  public getQuizById(id: number) {
    return this._http.get(`${baseUrl}/quiz/quizlist/` + id);
  }

  public addQuiz(quiz: Quiz) {
    return this._http.post(`${baseUrl}/quiz/quizlist`, quiz);
  }

  public updateQuiz(quiz: Quiz) {
    return this._http.put(`${baseUrl}/quiz/quizlist`, quiz);
  }

  public deleteQuiz(id: number) {
    return this._http.delete(`${baseUrl}/quiz/quizlist/` + id);
  }

}
