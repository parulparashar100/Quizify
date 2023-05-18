import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class AttemptService {

  constructor(private _http: HttpClient) { }

  public getAllattemptsByUserId(userId: any) {
    return this._http.get(`${baseUrl}/attempt/attemptlist/userid/` + userId);
  }

}
