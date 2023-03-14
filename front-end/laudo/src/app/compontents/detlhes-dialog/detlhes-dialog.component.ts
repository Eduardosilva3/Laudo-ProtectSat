import { Component, Inject } from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import { Ordem } from 'src/app/tecnico/model/ordem';

@Component({
  selector: 'app-detlhes-dialog',
  templateUrl: './detlhes-dialog.component.html',
  styleUrls: ['./detlhes-dialog.component.css']
})
export class DetlhesDialogComponent {

  dataRecebimento = new Date()
  dataFinal = new Date()

  constructor(
    public dialogRef: MatDialogRef<DetlhesDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Ordem,
  ) {
    this.dataRecebimento = new Date(data.ordemEtapa.date_2)
    


  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  mes(data:number):String{
    if(data < 10){
      return "0"+data;
    }else{
      return "" +data
    }
  }
}
