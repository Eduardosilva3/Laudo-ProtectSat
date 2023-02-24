import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TecnicoModule } from './tecnico/tecnico.module';

import { NavegacaoComponent } from './navegacao/navegacao.component';
import { FormsModule } from '@angular/forms';
import { ManutencaoModule } from './manutencao/manutencao.module';



@NgModule({
  declarations: [
    AppComponent,
    NavegacaoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TecnicoModule,
    FormsModule,
    ManutencaoModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
