import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthTecnicoGuard } from './guards/auth-tecnico.guard';
import { NavegacaoComponent } from './navegacao/navegacao.component';
import { ListLaudoComponent } from './tecnico/list-laudo/list-laudo.component';
import { NovoLaudoComponent } from './tecnico/novo-laudo/novo-laudo.component';
import { ProgressoLaudoComponent } from './tecnico/progresso-laudo/progresso-laudo.component';
import { TelaPrincipalComponent } from './tecnico/tela-principal/tela-principal.component';

const routes: Routes = [

  {path: '', component: NavegacaoComponent},


  { path: 'progresso', component:ProgressoLaudoComponent, canActivate:[AuthTecnicoGuard] },
  {
    path: 'tecnico',
    component: TelaPrincipalComponent
    , canActivate:[AuthTecnicoGuard],
    children: [
    { path: 'novo', component: NovoLaudoComponent },
    { path: 'lista-ordens', component:ListLaudoComponent }


    ]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
