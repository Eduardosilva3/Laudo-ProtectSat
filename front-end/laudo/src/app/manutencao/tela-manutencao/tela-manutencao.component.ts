import { Component } from '@angular/core';
import { OrdemService } from 'src/app/tecnico/services/ordem.service';

@Component({
  selector: 'app-tela-manutencao',
  templateUrl: './tela-manutencao.component.html',
  styleUrls: ['./tela-manutencao.component.css']
})
export class TelaManutencaoComponent {

    constructor(public service:OrdemService){}
    
}
