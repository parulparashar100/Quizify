import { Component } from '@angular/core';
import { Category } from 'src/app/interfaces/category';
import { CategoryService } from 'src/app/services/category.service';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-show-category',
  templateUrl: './show-category.component.html',
  styleUrls: ['./show-category.component.css']
})
export class ShowCategoryComponent {

  categories: any;
  isAdmin: boolean = false;

  constructor(private _categoryService: CategoryService, private _loginService: LoginService) {

  }

  ngOnInit(): void {
    this.setIsAdmin();
    this.getCategories();
  }

  setIsAdmin() {
    if(this._loginService.getUserRole() === "admin") {
      this.isAdmin = true;
    } else {
      this.isAdmin = false;
    }
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

}
