import { Component, Input, OnInit } from '@angular/core';
import { Ordem } from 'src/app/tecnico/model/ordem';
import { OrdemService } from 'src/app/tecnico/services/ordem.service';

@Component({
  selector: 'app-tela-manutencao',
  templateUrl: './tela-manutencao.component.html',
  styleUrls: ['./tela-manutencao.component.css']
})
export class TelaManutencaoComponent implements OnInit{



    constructor(public service:OrdemService){}


    ngOnInit(): void {


      this.exibirOrdem = false


      this.service.getOrdem().subscribe((ord:Ordem[])=>{

        this.ordem = []
        this.ordemTemporario = []

       this.ordemTemporario = ord
       this.ordemTemporario.forEach(element => {
          if(!element.ordemEtapa.etapa_4){
            this.ordem.push(element)

          }
       });
       this.pendente = this.ordem.length
      })

      this.service.getOrdem().subscribe((ord:Ordem[])=>{

        this.ordem = []
        this.ordemTemporario = []

       this.ordemTemporario = ord
       this.ordemTemporario.forEach(element => {
            var data = new Date(element.ordemEtapa.date_3)


          if(data < new Date()&&data.getFullYear()>=2022){

            this.ordem.push(element)

          }
       });
       this.atrasadas = this.ordem.length
      })


      this.service.getOrdem().subscribe((ord:Ordem[])=>{

        this.ordem = []
        this.ordemTemporario = []

       this.ordemTemporario = ord
       this.ordemTemporario.forEach(element => {
          if(element.ordemEtapa.etapa_4){
            this.ordem.push(element)

          }
       });
       this.concluida = this.ordem.length
      })






  }

    ordem:Ordem[] = []
    ordemTemporario:Ordem[] = []

    buscaOrdem:string
    exibirOrdem:boolean

    pendente:number = 0
    atrasadas:number = 0
    concluida:number = 0

    getOrdemPendente(){

      this.exibirOrdem = false
      this.ordem = []
      this.ordemTemporario = []

      this.service.getOrdem().subscribe((ord:Ordem[])=>{


       this.ordemTemporario = ord
       this.ordemTemporario.forEach(element => {
          if(!element.ordemEtapa.etapa_4){
            this.ordem.push(element)

          }
       });


       this.exibirOrdem = true





      })
    }

    getOrdemAtrasada(){
      this.exibirOrdem = false

      this.service.getOrdem().subscribe((ord:Ordem[])=>{

        this.ordem = []
        this.ordemTemporario = []

       this.ordemTemporario = ord
       this.ordemTemporario.forEach(element => {
            var data = new Date(element.ordemEtapa.date_3)


          if(data < new Date()&&data.getFullYear()>=2022){
            console.log(data)
            this.ordem.push(element)

          }
       });

       this.exibirOrdem = true

      })
    }

    getOrdemConcluida(){
      this.exibirOrdem = false
      this.service.getOrdem().subscribe((ord:Ordem[])=>{

        this.ordem = []
        this.ordemTemporario = []

       this.ordemTemporario = ord
       this.ordemTemporario.forEach(element => {
          if(element.ordemEtapa.etapa_4){
            this.ordem.push(element)

          }
       });
       this.exibirOrdem = true
      })
    }


    public tratarOrdem(ord:Ordem) {

      this.exibirOrdem = false

    }







}
