import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, Observable, retry, throwError } from 'rxjs';
import { OrdemService } from 'src/app/tecnico/services/ordem.service';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {




  url = 'http://192.168.0.14:8080/user'; // api rest fake

  // injetando o HttpClient
  constructor(private httpClient: HttpClient,  private route:Router) { }






  // Headers
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'}

    )




  }





  // cria ordem
  validarUser(user:User): Observable<any> {



    return this.httpClient.post<User>(this.url, JSON.stringify(user), this.httpOptions)
      .pipe(
        retry(2),
        catchError(this.handleError)
      )
  }





  // Manipulação de erros
  handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Erro ocorreu no lado do client
      errorMessage = error.error.message;
    } else {
      // Erro ocorreu no lado do servidor
      errorMessage = `Código do erro: ${error.status}, ` + `menssagem: ${error.message}`;

    }
    console.log(errorMessage);
    return throwError(errorMessage);
  };
}
