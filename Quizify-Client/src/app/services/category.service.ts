import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Category } from '../interfaces/category';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private _http: HttpClient) { }

  public getAllCategory() {
    return this._http.get(`${baseUrl}/category/categorylist`);
  }

  public getCategoryById(id: number) {
    return this._http.get(`${baseUrl}/category/categorylist/` + id);
  }

  public addCategory(category: Category) {
    return this._http.post(`${baseUrl}/category/categorylist`, category);
  }

  public updateCategory(category: Category) {
    return this._http.put(`${baseUrl}/category/categorylist`, category);
  }

  public deleteCategory(id: number) {
    return this._http.delete(`${baseUrl}/category/categorylist/` + id);
  }

}
