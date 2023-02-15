import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { OrdemEtapa } from 'src/app/tecnico/model/ordem-etapa';
import { EtapasService } from '../services/etapas.service';

@Component({
  selector: 'app-tratamento-ordem',
  templateUrl: './tratamento-ordem.component.html',
  styleUrls: ['./tratamento-ordem.component.css']
})
export class TratamentoOrdemComponent{


  @Input() etapa: OrdemEtapa
  @Input() temporario: boolean
  @Input() final: boolean
  @Output() ordemTrat = new EventEmitter()

  constructor(private service:EtapasService){

  }
  

  

  atualizaEtapa(ordEt:OrdemEtapa){
    this.service.putEtapa(ordEt).subscribe((etapa:OrdemEtapa)=>{
      this.etapa = etapa
    })
  }

  receberLaudoTemporario(f:NgForm){
    
    var data = new Date(f.value.dataPrevisao)
    data.setDate(data.getDate() + 1);
    this.etapa.etapa_3 = true
    this.etapa.date_3 = data
    this.etapa.laudoTemporario = f.value.laudoTemporario
    this.atualizaEtapa(this.etapa)



    this.ordemTrat.emit(true)
    f.reset
    
  }

  receberLaudoFinal(f:NgForm){
    this.etapa.laudoFinal = f.value.laudoFinal
    this.etapa.etapa_4 = true
    this.atualizaEtapa(this.etapa)
    this.ordemTrat.emit(true)
    f.reset

  }
}
