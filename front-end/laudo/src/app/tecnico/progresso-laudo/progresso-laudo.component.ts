import { Component, Input, OnInit } from '@angular/core';
import { Ordem } from '../model/ordem';
import { OrdemService } from '../services/ordem.service';

@Component({
  selector: 'app-progresso-laudo',
  templateUrl: './progresso-laudo.component.html',
  styleUrls: ['./progresso-laudo.component.css']
})
export class ProgressoLaudoComponent implements OnInit{


  ordem = new Ordem()

  constructor(private service:OrdemService){

  }
  ngOnInit(): void {
    console.log("Iniciou")
    this.ordem = this.service.enviarProgresso()
    console.log(this.ordem)
    
  }

  


  public receberOrdem(ord:Ordem){

  }
}
