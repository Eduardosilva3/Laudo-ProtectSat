import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Ordem } from '../model/ordem';
import { OrdemService } from '../services/ordem.service';


@Component({
  selector: 'app-novo-laudo',
  templateUrl: './novo-laudo.component.html',
  styleUrls: ['./novo-laudo.component.css']
})
export class NovoLaudoComponent implements OnInit {

    
    
    ordem = new Ordem()
    alert:boolean =false
    idOrdem?:number;
    alertForm:string;
    alertFormIf:boolean = false;
    cnpj:String =""
    constructor(private service: OrdemService) {}
  
    ngOnInit(): void {
    this.alert = false;
    this.alertFormIf = false;
    }
    

    formatarCnpj(){
      console.log(this.cnpj.length)
      
      if(this.cnpj.length==2){
        this.cnpj+="."
      }
      
      if(this.cnpj.length==6){
        this.cnpj+="."
      }

      if(this.cnpj.length==10){
        this.cnpj+="."
      }

      if(this.cnpj.length==15){
        this.cnpj+="-"
      }

      
    }


    cadastrarOrdem(f:NgForm){
     
      this.ordem.cnpjCliente = f.value.cnpj
      this.ordem.descricaoProblema = f.value.descricao
      this.ordem.nomeCliente = f.value.cliente
      this.ordem.idEquipamento = f.value.id

      if(this.ordem.cnpjCliente===""){
        this.alertForm = "CNPJ Invalido!"
        this.alertFormIf =true
      }else if(this.ordem.nomeCliente ===""){
        this.alertForm = "Digite o nome do cliente!"
        this.alertFormIf =true
      }else if(this.ordem.idEquipamento.toString()===""||this.ordem.idEquipamento.toString().length<=5){
        this.alertForm = "Verificar o ID do equipamento!"
        this.alertFormIf =true
      }else if(this.ordem.descricaoProblema.length<50){
        this.alertForm = "Verifica a Descrição do problema"
        this.alertFormIf =true
      }else{
        this.alertFormIf =false
      this.service.saveOrdem(this.ordem).subscribe((ord:Ordem) => {
        
        
        this.ordem = ord;
        this.idOrdem = ord.idOrdem
        this.confirmacao(f);

        
      });
      }




      
      
      
    }

    // limpa o formulario
  cleanForm(form: NgForm) {
    this.ordem = new Ordem()
    form.resetForm();
    
  }

  confirmacao(f:NgForm){
    this.alert = true;
    
    this.cleanForm(f);
  }

    

}
