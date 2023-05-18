import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Category } from 'src/app/interfaces/category';
import { CategoryService } from 'src/app/services/category.service';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent {

  category: Category;

  constructor(private _categoryService: CategoryService, private _snackBar: MatSnackBar) {
    this.category = {"id": 0, "name": '', "description": ''};
  }

  addCategory(){
    this._categoryService.addCategory(this.category).subscribe({
      next: (data)=> {
        this._snackBar.open("Category Added Successfully", "OK", {
          duration: 3000,
          verticalPosition: 'top'
        });
        this.category = {"id": 0, "name": '', "description": ''};
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
