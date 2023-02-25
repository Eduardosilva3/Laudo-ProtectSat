import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse
} from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { OrdemService } from 'src/app/tecnico/services/ordem.service';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(private service:OrdemService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    var token = localStorage.getItem("token")

    if(token!=null){
      request = request.clone({
        setHeaders: {
            Authorization: `Bearer ${token}`,
            token: `${token}`
        }
      });

      return next.handle(request).pipe(catchError(error => {

        if(error instanceof HttpErrorResponse && error.status ===401){
          this.service.logout()
          return throwError(error)
        }else{
          return throwError(error)
        }


      }))
    }else{
      return next.handle(request);
    }





  }
}
