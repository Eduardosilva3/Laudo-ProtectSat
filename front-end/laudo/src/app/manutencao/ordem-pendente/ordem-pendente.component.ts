import { Component } from '@angular/core';
import { Ordem } from 'src/app/tecnico/model/ordem';
import { OrdemService } from 'src/app/tecnico/services/ordem.service';


@Component({
  selector: 'app-ordem-pendente',
  templateUrl: './ordem-pendente.component.html',
  styleUrls: ['./ordem-pendente.component.css']
})
export class OrdemPendenteComponent {

    constructor(private service:OrdemService){}

    ordem:Ordem[]
    corStatus:string;

    getOrdemPendente(){

      
      this.service.getOrdem().subscribe((ord:Ordem[])=>{


          ord.forEach(element => {
            if(!element.ordemEtapa.etapa_4){
              this.ordem.push(element)
            }
          });

          this.verificarStatus()

        
        })
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

        



    

      
      


   
    

