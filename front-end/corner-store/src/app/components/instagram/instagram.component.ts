import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-instagram',
  templateUrl: './instagram.component.html',
  styleUrls: ['./instagram.component.scss']
})
export class InstagramComponent implements OnInit {

  images = [
    "../../../assets/img/insta-1.jpg",
    "../../../assets/img/insta-2.jpg",
    "../../../assets/img/insta-3.jpg",
    "../../../assets/img/insta-4.jpg",
    "../../../assets/img/insta-5.jpg",
    "../../../assets/img/insta-6.jpg"
  ]

  constructor() { }

  ngOnInit() {
  }

}
