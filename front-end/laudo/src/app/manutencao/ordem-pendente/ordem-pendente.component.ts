import { Component, EventEmitter, Input, OnDestroy, OnInit, Output } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DetlhesDialogComponent } from 'src/app/compontents/detlhes-dialog/detlhes-dialog.component';
import { Ordem } from 'src/app/tecnico/model/ordem';
import { OrdemService } from 'src/app/tecnico/services/ordem.service';


@Component({
  selector: 'app-ordem-pendente',
  templateUrl: './ordem-pendente.component.html',
  styleUrls: ['./ordem-pendente.component.css']
})

export class OrdemPendenteComponent implements OnInit, OnDestroy{

  @Input() lista:Ordem[]
  @Output() onClose = new EventEmitter()
  


  ordem:Ordem[] = []

    constructor(private service:OrdemService, public dialog: MatDialog
      ){}

    ngOnDestroy(): void {

    this.lista = []
    this.ordem = []
  }

  abrirDetalhes(ord:Ordem){
    this.abrirDialogo(ord)
  }

  closeEvent(ord:Ordem){
    this.onClose.emit(ord)
  }

  determinarTextoBotao(ord:Ordem):String{

    if(!ord.ordemEtapa.etapa_3){
      return "L. Temporario"
    }else{
      return "L. Final"
    }
  }



  ngOnInit(): void {
    this.ordem = this.lista
    this.verificarStatus()
  }


    corStatus:string;


    pendente(ord:Ordem[]){

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


      abrirDialogo(ord:Ordem): void {
        const dialogRef = this.dialog.open(DetlhesDialogComponent, {
          data: ord,
        });

        dialogRef.afterClosed().subscribe((result:Ordem) => {

          this.closeEvent(result)

        });
      }



    }














