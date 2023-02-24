import { Component, OnInit } from '@angular/core';
import { Form, NgForm } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { User } from './model/user';
import { UserService } from './services/user.service';

@Component({
  selector: 'app-navegacao',
  templateUrl: './navegacao.component.html',
  styleUrls: ['./navegacao.component.css']
})
export class NavegacaoComponent implements OnInit{


  constructor(private service:UserService, private router:Router){}

  ngOnInit(): void {
      var storage = localStorage.getItem('type')

      if(storage=="tecnico"){
        this.router.navigate(['tecnico'])
      }else if(storage==="manutencao"){
        this.router.navigate(['manutencao'])
      }
  }

  validar:boolean;


  user = new User();



  login(user:User){
    this.service.validarUser(user).subscribe((type:User)=>{

      if(type.type!="Erro Login"){
        localStorage.setItem("type",type.type)
        this.navegacao(type.type)
      }else{
        this.validar = true
      }
    })
  }

  navegacao(type:string){
    if(type==="tecnico"){
      this.router.navigate(['tecnico'])
    }else if(type==="manutencao"){
      this.router.navigate(['manutencao'])
    }
  }



}
