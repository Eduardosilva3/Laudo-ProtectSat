import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Routes } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TecnicoModule } from './tecnico/tecnico.module';

import { NavegacaoComponent } from './navegacao/navegacao.component';
import { FormsModule } from '@angular/forms';
import { ManutencaoModule } from './manutencao/manutencao.module';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from './services/interceptors/token.interceptor';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatBadgeModule} from '@angular/material/badge';
import { DetlhesDialogComponent } from './compontents/detlhes-dialog/detlhes-dialog.component';
import {MatDialogModule} from '@angular/material/dialog';
import{MatButtonModule} from '@angular/material/button'




@NgModule({
  declarations: [
    AppComponent,
    NavegacaoComponent,
    DetlhesDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    TecnicoModule,
    FormsModule,
    ManutencaoModule,
    BrowserAnimationsModule,
    MatBadgeModule,
    MatDialogModule,
    MatButtonModule

  ],
  providers: [{provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi: true,}],
  bootstrap: [AppComponent]
})
export class AppModule { }
