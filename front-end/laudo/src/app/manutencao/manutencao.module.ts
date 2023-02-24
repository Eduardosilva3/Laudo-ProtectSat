import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TelaManutencaoComponent } from './tela-manutencao/tela-manutencao.component';
import { AppRoutingModule } from '../app-routing.module';
import { OrdemPendenteComponent } from './ordem-pendente/ordem-pendente.component';
import { ManutencaoRoutingModule } from './manutencao-routing.module';
import { TratamentoOrdemComponent } from './tratamento-ordem/tratamento-ordem.component';
import { FormsModule } from '@angular/forms';




@NgModule({
  declarations: [
    TelaManutencaoComponent,
    OrdemPendenteComponent,
    TratamentoOrdemComponent
    
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    ManutencaoRoutingModule,
    FormsModule

  ]
})
export class ManutencaoModule { }
