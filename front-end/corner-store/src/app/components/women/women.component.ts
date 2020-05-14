import { Component, OnInit } from '@angular/core';
import { OwlOptions } from 'ngx-owl-carousel-o';
import { ProductService } from 'src/app/services/product.service';
import { Product } from 'src/app/Models/Product';

@Component({
  selector: 'app-women',
  templateUrl: './women.component.html',
  styleUrls: ['./women.component.scss']
})
export class WomenComponent implements OnInit {


  customOptions: OwlOptions = {
    loop: true,
    mouseDrag: true,
    touchDrag: true,
    pullDrag: true,
    dots: false,
    navSpeed: 700,
    smartSpeed: 2000,
    autoplay:true,
    autoplayTimeout: 3000,
    autoplayHoverPause: true,
    margin:40,
    responsive: {
      0: {
        items: 3
      }
    },
    nav: false,
    navText: ["", ""]
  };

  slidesStore:Product[];

  constructor(private productService:ProductService) { }

  ngOnInit() {
    this.productService.getAll().subscribe(
      products =>{
        this.slidesStore = products;
      } 
    )
      
  }

}
