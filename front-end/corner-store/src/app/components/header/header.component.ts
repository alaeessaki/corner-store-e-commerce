import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/category.service';
import { Category } from 'src/app/Models/Category';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  categories:Observable<Category[]>;
  constructor(private _categoryService:CategoryService) { }

  ngOnInit() {
    this.categories = this._categoryService.getAllCategories();
  }

}
