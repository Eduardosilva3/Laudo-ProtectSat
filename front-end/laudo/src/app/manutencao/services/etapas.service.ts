import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, retry, throwError } from 'rxjs';
import { OrdemEtapa } from 'src/app/tecnico/model/ordem-etapa';

@Injectable({
  providedIn: 'root'
})
export class EtapasService {

  
  url = 'http://172.19.1.34:8080/etapa'; // api rest fake

  // injetando o HttpClient
  constructor(private httpClient: HttpClient) { }

  

  

 

  
  // Headers
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

 

 

  
  // Atualiza Etapa
  putEtapa(ordEt: OrdemEtapa): Observable<OrdemEtapa> {
    return this.httpClient.put<OrdemEtapa>(this.url, JSON.stringify(ordEt), this.httpOptions)
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
