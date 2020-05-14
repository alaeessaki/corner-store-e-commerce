import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { AuthentificationService } from '../services/authentification.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  error="";
  userDetails:FormGroup;

  constructor(private authentificationService:AuthentificationService, private router:Router) { 
    this.userDetails= new FormGroup({
      username: new FormControl("", Validators.required),
      password: new FormControl("", Validators.required)
    })
  }

  ngOnInit() {

  }

  login(){
    this.authentificationService.login(this.userDetails.get('username').value, this.userDetails.get('password').value).subscribe(
      success=> {
        this.router.navigate(['/'])
      },
      error=>{
        this.error = "user details are not correct"
      }
    )
  }
}
