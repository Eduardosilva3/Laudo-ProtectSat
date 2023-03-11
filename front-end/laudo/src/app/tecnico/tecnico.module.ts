import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TecnicoRoutingModule } from './tecnico-routing.module';
import { TelaPrincipalComponent } from './tela-principal/tela-principal.component';
import { NovoLaudoComponent } from './novo-laudo/novo-laudo.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ListLaudoComponent } from './list-laudo/list-laudo.component';
import { ProgressoLaudoComponent } from './progresso-laudo/progresso-laudo.component';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';


@NgModule({
  declarations: [
    TelaPrincipalComponent,
    NovoLaudoComponent,
    ListLaudoComponent,
    ProgressoLaudoComponent,

  ],
  imports: [
    CommonModule,
    TecnicoRoutingModule,
    FormsModule,
    HttpClientModule,
    MatButtonModule,
    MatIconModule,
    ReactiveFormsModule,
    MatInputModule

  ],
  exports:[
    NovoLaudoComponent
  ]
})
export class TecnicoModule { }
