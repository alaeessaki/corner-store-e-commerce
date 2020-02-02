import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Category } from "../Models/Category";
import { Observable } from 'rxjs';

@Injectable({
  providedIn: "root"
})
export class CategoryService {
  constructor(private _http: HttpClient) {}

  getAllCategories():Observable<Category[]> {
    // const headers = new HttpHeaders({
    //   'Authorization': 'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhbGFlZXNzYWtpIiwiZXhwIjoxNTgwNDk5MjkzLCJpYXQiOjE1ODA0NjMyOTN9.tdEUxGTh0k3D1Xz433D77H0m-ydeoJZrjuQ9nLgPjTc'
    // })
    // const httpOptions = {
    //   headers: headers
    // };
    return this._http.get<Category[]>("http://localhost:8015/api/categories");
  }
}
