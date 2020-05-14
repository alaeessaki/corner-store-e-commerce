import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Jwt } from '../Models/Jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {

  private currentUserSubject: BehaviorSubject<any>;
  public currentUser: Observable<any>;
  
  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<any>(JSON.parse(localStorage.getItem("jwt")));
    this.currentUser = this.currentUserSubject.asObservable();
   }

   public get currentUserValue(){
    return this.currentUserSubject.value;
  }

  login(username: string, password:string){
    return this.http.post<any>("http://localhost:8015/authenticate", {username, password}).pipe(
      map(jwt=>{
        localStorage.setItem("jwt", JSON.stringify(jwt));
        this.currentUserSubject.next(jwt);
        return jwt;
      })
    )

  }

  logout(){
    localStorage.removeItem("jwt");
    this.currentUserSubject.next(null);
  }
}
