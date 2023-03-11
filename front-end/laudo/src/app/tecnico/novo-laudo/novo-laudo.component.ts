import { Component, OnInit } from '@angular/core';
import { NgForm, FormGroup, FormBuilder, FormControl, Validator, Validators, FormControlName } from '@angular/forms';
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
    formulario: FormGroup



    constructor(private service: OrdemService, private formBuider:FormBuilder) {}

    ngOnInit(): void {




    this.buildeForm()


    this.alert = false;
    this.alertFormIf = false;
    }


    formatarCnpj(){

      this.cnpj = this.formulario.get('cnpj')?.value

      if(this.cnpj.length==2){
        //this.CnpjFormControll.setValue(this.CnpjFormControll.value+".")
        this.cnpj+="."
        this.formulario.get('cnpj')?.setValue(this.cnpj)

      }

      if(this.cnpj.length==6){
        //this.CnpjFormControll.setValue(this.CnpjFormControll.value+".")
        this.cnpj+="."
        this.formulario.get('cnpj')?.setValue(this.cnpj)
      }

      if(this.cnpj.length==10){
        //this.CnpjFormControll.setValue(this.CnpjFormControll.value+"/")
        this.cnpj+="/"
        this.formulario.get('cnpj')?.setValue(this.cnpj)
      }

      if(this.cnpj.length==15){
        //this.CnpjFormControll.setValue(this.CnpjFormControll.value+"-")
        this.cnpj+="-"
        this.formulario.get('cnpj')?.setValue(this.cnpj)
      }





    }

    buildeForm(){
      this.formulario = this.formBuider.group({
        cnpj: ['',[Validators.required, Validators.minLength(18)]],
        cliente:['', [Validators.required]],
        id:['', [Validators.required, Validators.minLength(6)]],
        descricao:['', [Validators.required, Validators.minLength(10)]]

      });
    }


    cadastrarOrdem(){


      this.ordem.cnpjCliente = this.formulario.value.cnpj
      this.ordem.descricaoProblema = this.formulario.value.descricao
      this.ordem.nomeCliente = this.formulario.value.cliente
      this.ordem.idEquipamento = this.formulario.value.id

      this.service.saveOrdem(this.ordem).subscribe((ord:Ordem) => {


        this.ordem = ord;
        this.idOrdem = ord.idOrdem
        this.confirmacao();


      });

    }

    /*cadastrarOrdem(f:NgForm){

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







    }*/

    // limpa o formulario
  cleanForm() {
    this.ordem = new Ordem()
    this.buildeForm()

  }

  confirmacao(){
    this.alert = true;

    this.cleanForm();
  }



}
