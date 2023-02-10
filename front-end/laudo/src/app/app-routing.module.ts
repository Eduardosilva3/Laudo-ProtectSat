import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavegacaoComponent } from './navegacao/navegacao.component';
import { NovoLaudoComponent } from './tecnico/novo-laudo/novo-laudo.component';
import { TelaPrincipalComponent } from './tecnico/tela-principal/tela-principal.component';

const routes: Routes = [

  {path: '', component: NavegacaoComponent},
  {
    path: 'tecnico',
    component: TelaPrincipalComponent
    ,
    children: [
    { path: 'novo', component: NovoLaudoComponent }

    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
