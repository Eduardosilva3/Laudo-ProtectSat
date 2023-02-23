import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { catchError, Observable, retry, throwError } from 'rxjs';
import { Ordem } from '../model/ordem';

@Injectable({
  providedIn: 'root'
})
export class OrdemService {

  url = 'http://172.19.1.34:8080/ordem'; // api rest fake

  // injetando o HttpClient
  constructor(private httpClient: HttpClient,  private route:Router) { }

  logout(){
    localStorage.clear()
    this.route.navigate([''])
  }

  ordem = new Ordem()

  receberProgresso(ord:Ordem){

    this.ordem = ord
    
    this.route.navigate(['progresso']);

  }

  enviarProgresso():Ordem{
      return this.ordem
  }

  // Headers
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  // Obtem todas as ordens
  getOrdem(): Observable<Ordem[]> {
    return this.httpClient.get<Ordem[]>(this.url)
      .pipe(
        retry(2),
        catchError(this.handleError))
  }

  // Obtem ordem pelo cnpj
  getOrdemCnpj(cnpj: string): Observable<Ordem[]> {
    return this.httpClient.get<Ordem[]>(this.url + '/cnpj?cnpj=' + cnpj)
      .pipe(
        retry(2),
        catchError(this.handleError)
      )
  }

  // Obtem ordem pelo id
  getOrdemById(id: number): Observable<Ordem> {
    return this.httpClient.get<Ordem>(this.url + '/id/' + id)
      .pipe(
        retry(2),
        catchError(this.handleError)
      )
  }

  // cria ordem
  saveOrdem(ord: Ordem): Observable<Ordem> {
    return this.httpClient.post<Ordem>(this.url, JSON.stringify(ord), this.httpOptions)
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
