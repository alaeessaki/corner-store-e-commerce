import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthentificationService } from '../services/authentification.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {

  constructor(private authenticationService: AuthentificationService) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    
    let currentUser = this.authenticationService.currentUserValue;
    if(currentUser){
      request = request.clone({
        setHeaders:{
          Authorization : `Bearer ${currentUser.jwt}`
        }
      });
    }
    
    return next.handle(request);
  }
}
