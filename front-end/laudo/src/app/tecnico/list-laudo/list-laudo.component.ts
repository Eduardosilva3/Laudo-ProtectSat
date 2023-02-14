import { ThisReceiver } from '@angular/compiler';
import { Component, EventEmitter, OnInit, Output, Type } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router, RouterLink, TitleStrategy } from '@angular/router';
import { Etapas } from '../model/etapas';
import { Ordem } from '../model/ordem';
import { ProgressoLaudoComponent } from '../progresso-laudo/progresso-laudo.component';
import { OrdemService } from '../services/ordem.service';

@Component({
  selector: 'app-list-laudo',
  templateUrl: './list-laudo.component.html',
  styleUrls: ['./list-laudo.component.css']
})
export class ListLaudoComponent implements OnInit{
  
 

  constructor(private service: OrdemService){}

  ordem:Ordem[];
  corStatus:string;

  ngOnInit(): void {
    
  }

  exibirDetalhes(ord:Ordem){
      
      this.service.receberProgresso(ord);

     

  }

  buscarOs(f:NgForm){
    let id = f.value.busca

    this.ordem = []

    this.service.getOrdemById(id).subscribe((ord:Ordem)=>{
      this.ordem[0] = ord
      this.verificarStatus()
    })
  }

  buscarCnpj(f:NgForm){

    console.log(f.value.busca)
    let cnpj:string = f.value.busca
    let cnpjFormatado:string;

    

    cnpjFormatado = cnpj.substring(0,2) + "." + cnpj.substring(2,5) + "." + cnpj.substring(5,8) +"/"+ cnpj.substring(8,12) + "-" + cnpj.substring(12,14)
    
    this.service.getOrdemCnpj(cnpjFormatado).subscribe((ord:Ordem[])=>{
      this.ordem = ord;
      this.verificarStatus()
    })
    
   
  }

  getOrdem(){
    this.service.getOrdem().subscribe((ord:Ordem[])=>{
      this.ordem = ord
      this.verificarStatus()
     
    });
  }

  verificarStatus(){
    
    

    this.ordem.forEach(function (value) {
      if(value.ordemEtapa.etapa_1&&value.ordemEtapa.etapa_2==false&&value.ordemEtapa.etapa_3==false&&value.ordemEtapa.etapa_4==false){
        value.status = "Recebido do Cliente"
        
        
    }else if(value.ordemEtapa.etapa_2&&value.ordemEtapa.etapa_3==false&&value.ordemEtapa.etapa_4==false){
      value.status = "Enviado para Manutenção"
    }else if(value.ordemEtapa.etapa_3&&value.ordemEtapa.etapa_4==false){
      value.status = "Em analise Tecnica"
    }else{
      value.status = "Concluido"
    }



  });

  
  }


  determinarCor(valor?:String):String{
    if(valor==="Recebido do Cliente"){
      return "#d7d803";
    }else if(valor==="Enviado para Manutenção"){
      return "#d7d803";
    }else if(valor==="Em analise Tecnica"){
      return "#d7d803";
    }else{
      return "#98fb98"
    }
  }
    

}
