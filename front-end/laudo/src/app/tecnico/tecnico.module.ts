import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TecnicoRoutingModule } from './tecnico-routing.module';
import { TelaPrincipalComponent } from './tela-principal/tela-principal.component';
import { NovoLaudoComponent } from './novo-laudo/novo-laudo.component';


@NgModule({
  declarations: [
    TelaPrincipalComponent,
    NovoLaudoComponent
  ],
  imports: [
    CommonModule,
    TecnicoRoutingModule
  ],
  exports:[
    NovoLaudoComponent
  ]
})
export class TecnicoModule { }
