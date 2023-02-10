import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TecnicoModule } from './tecnico/tecnico.module';

import { NavegacaoComponent } from './navegacao/navegacao.component';



@NgModule({
  declarations: [
    AppComponent,
    NavegacaoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TecnicoModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
