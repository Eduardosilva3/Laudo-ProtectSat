import { Component } from '@angular/core';
import { OrdemService } from '../services/ordem.service';

@Component({
  selector: 'app-tela-principal',
  templateUrl: './tela-principal.component.html',
  styleUrls: ['./tela-principal.component.css']
})
export class TelaPrincipalComponent {

  constructor(public service:OrdemService){}


}
