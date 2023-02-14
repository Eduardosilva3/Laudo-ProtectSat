import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TelaManutencaoComponent } from './tela-manutencao/tela-manutencao.component';
import { AppRoutingModule } from '../app-routing.module';
import { OrdemPendenteComponent } from './ordem-pendente/ordem-pendente.component';
import { ManutencaoRoutingModule } from './manutencao-routing.module';




@NgModule({
  declarations: [
    TelaManutencaoComponent,
    OrdemPendenteComponent
    
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    ManutencaoRoutingModule

  ]
})
export class ManutencaoModule { }
