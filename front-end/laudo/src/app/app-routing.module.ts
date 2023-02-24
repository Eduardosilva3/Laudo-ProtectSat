import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthManutencaoGuard } from './guards/auth-manutencao.guard';
import { AuthTecnicoGuard } from './guards/auth-tecnico.guard';
import { OrdemPendenteComponent } from './manutencao/ordem-pendente/ordem-pendente.component';
import { TelaManutencaoComponent } from './manutencao/tela-manutencao/tela-manutencao.component';
import { NavegacaoComponent } from './navegacao/navegacao.component';
import { ListLaudoComponent } from './tecnico/list-laudo/list-laudo.component';
import { NovoLaudoComponent } from './tecnico/novo-laudo/novo-laudo.component';
import { ProgressoLaudoComponent } from './tecnico/progresso-laudo/progresso-laudo.component';
import { TelaPrincipalComponent } from './tecnico/tela-principal/tela-principal.component';

const routes: Routes = [

  {path: '', component: NavegacaoComponent},
  {path: 'manutencao', component:TelaManutencaoComponent, canActivate:[AuthManutencaoGuard], 
    children:[
      {path:'pendente', component:OrdemPendenteComponent}
    ]
    },


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
