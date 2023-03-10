import { Component, Input, OnInit } from '@angular/core';
import { Ordem } from '../model/ordem';
import { OrdemService } from '../services/ordem.service';

@Component({
  selector: 'app-progresso-laudo',
  templateUrl: './progresso-laudo.component.html',
  styleUrls: ['./progresso-laudo.component.css']
})
export class ProgressoLaudoComponent implements OnInit{

  step1:string
  step2:string
  step3:string
  step4:string

  date1 = new Date() 
  date2 = new Date() 
  date3 = new Date() 


  ordem = new Ordem()

  constructor(public service:OrdemService){

  }


  ngOnInit(): void {
    
    this.ordem = this.service.enviarProgresso()

    this.receberOrdem(this.ordem)

  }

  previsaoData:boolean
  laudoFinal:boolean
  laudoTemporario:boolean

  textoLaudoTemporario:string;
  linkLaudoFinal:string


  exibirLaudoTemporario(){
    this.laudoTemporario = true
  }


  public receberOrdem(ord:Ordem){
    
    
    
    this.ordem.ordemEtapa.date_1 = new Date(ord.ordemEtapa.date_1)
    
    this.ordem.ordemEtapa.date_2 = new Date(ord.ordemEtapa.date_2)
    this.ordem.ordemEtapa.date_3 = new Date(ord.ordemEtapa.date_3)

    this.textoLaudoTemporario = ord.ordemEtapa.laudoTemporario
    this.linkLaudoFinal = ord.ordemEtapa.laudoFinal

      if(this.ordem.ordemEtapa.etapa_1){
        this.step1 = "active"
      }

      if(this.ordem.ordemEtapa.etapa_2){
        this.step2 = "active"
      }

      if(this.ordem.ordemEtapa.etapa_3){
        this.previsaoData = true
        this.step3 = "active"
      }

      if(this.ordem.ordemEtapa.etapa_4){
        this.laudoFinal = true
        this.step4 = "active"
      }


  }
}
