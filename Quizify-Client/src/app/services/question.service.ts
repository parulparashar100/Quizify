import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
import { Question } from '../interfaces/question';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private _http: HttpClient) { }

  public getAllQuestions() {
    return this._http.get(`${baseUrl}/question/questionlist`);
  }

  public getQuestionById(id: number) {
    return this._http.get(`${baseUrl}/question/questionlist/` + id);
  }

  public getQuestionByQuizId(quizId: number) {
    return this._http.get(`${baseUrl}/question/questionlist/quizid/` + quizId);
  }

  public addQuestion(question: Question) {
    return this._http.post(`${baseUrl}/question/questionlist`, question);
  }

  public updateQuestion(question: Question) {
    return this._http.put(`${baseUrl}/question/questionlist`, question);
  }

  public deleteQuestion(id: number) {
    return this._http.delete(`${baseUrl}/question/questionlis/t` + id);
  }

}
