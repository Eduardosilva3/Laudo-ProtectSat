import { Etapas } from "./etapas";
import { OrdemEtapa } from "./ordem-etapa";

export class Ordem {
    
    idOrdem?:number;
    cnpjCliente:string;
    idEquipamento:number;
    nomeCliente:string;
    descricaoProblema:string;
    status?:string;
    ordemEtapa:OrdemEtapa;
    
    

    

    
}
