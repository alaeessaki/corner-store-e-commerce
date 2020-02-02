import { Component, OnInit } from "@angular/core";
import { OwlOptions } from "ngx-owl-carousel-o";

@Component({
  selector: "app-hero-section",
  templateUrl: "./hero-section.component.html",
  styleUrls: ["./hero-section.component.scss"]
})
export class HeroSectionComponent implements OnInit {
  images = ["../../../assets/img/hero-1.jpg", "../../../assets/img/hero-2.jpg"];
  
  slidesStore = [
    {
      id: 1,
      title: "first title image",
      src: "../../../assets/img/carousel/hero-1.jpg",
      alt: "first image",
      gender: "women"
    },
    {
      id: 2,
      title: "second title image",
      src: "../../../assets/img/carousel/hero-2.jpg",
      alt: "second image",
      gender: "kids"
    }
  ];

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
    responsive: {
      0: {
        items: 1
      }
    },
    nav: false,
    navText: ["", ""]
  };

  constructor() {}

  ngOnInit() {}
}
