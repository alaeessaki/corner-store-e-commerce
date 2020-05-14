import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/category.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private categoryService: CategoryService, private productService:ProductService) { }

  ngOnInit() {
    this.categoryService.getAllCategories().subscribe(
      categories=>{
        console.log(categories);
      }
    )
    this.productService.getAll().subscribe(
      products=>{
        console.log(products);
      }
    )
  }

}
