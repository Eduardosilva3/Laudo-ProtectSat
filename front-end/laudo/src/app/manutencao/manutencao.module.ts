import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TelaManutencaoComponent } from './tela-manutencao/tela-manutencao.component';
import { AppRoutingModule } from '../app-routing.module';
import { OrdemPendenteComponent } from './ordem-pendente/ordem-pendente.component';
import { ManutencaoRoutingModule } from './manutencao-routing.module';
import { TratamentoOrdemComponent } from './tratamento-ordem/tratamento-ordem.component';
import { FormsModule } from '@angular/forms';
import {MatBadgeModule} from '@angular/material/badge'
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatTooltipModule} from '@angular/material/tooltip';




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
    FormsModule,
    MatBadgeModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatTooltipModule

  ]
})
export class ManutencaoModule { }
