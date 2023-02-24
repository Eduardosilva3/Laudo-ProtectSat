import { Component, Input, OnInit } from '@angular/core';
import { Ordem } from 'src/app/tecnico/model/ordem';
import { OrdemEtapa } from 'src/app/tecnico/model/ordem-etapa';
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
    etapa = new OrdemEtapa()
    buscaOrdem:string
    exibirOrdem:boolean
    editarEtapa:boolean

    pendente:number = 0
    atrasadas:number = 0
    concluida:number = 0

    getOrdemPendente(){
      this.confirmacaoAltEtapa = false
      this.editarEtapa = false
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
      this.confirmacaoAltEtapa = false
      this.editarEtapa = false
      
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
      this.confirmacaoAltEtapa = false
      this.editarEtapa = false
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

    temporario:boolean
    final:boolean

    public tratarOrdem(ord:Ordem) {
      this.etapa = ord.ordemEtapa

      this.exibirOrdem = false

      if(!this.etapa.etapa_3){
        this.temporario = true
        this.final = false
      }else if(this.etapa.etapa_3){
        this.temporario = false
        this.final = true
      }


      this.editarEtapa = true
      

    }


    confirmacaoAltEtapa:boolean

    public ordemTratada(e:boolean){
      this.editarEtapa = false
      this.ngOnInit()
      this.confirmacaoAltEtapa = true

    }







}
