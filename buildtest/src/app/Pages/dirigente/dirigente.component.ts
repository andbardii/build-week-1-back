import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Rivenditore } from 'src/app/Models/rivenditore';
import { DirigenteService } from 'src/app/Services/dirigente.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-dirigente',
  templateUrl: './dirigente.component.html',
  styleUrls: ['./dirigente.component.scss']
})
export class DirigenteComponent {

  allRivenditori:any;

  r: Rivenditore = {
    id: 0,
    nome: ''
  }
  constructor(private dSvc:DirigenteService, private router:Router) {}
  genera(): void {
    this.dSvc.create(this.r).subscribe(data => {
      console.log("RIVENDITORE GENERATO" + data);
    })

  }

  getAll(): void {
    this.dSvc.getAll().subscribe(data => {
      this.allRivenditori = data;
      console.log("TOTALE RIVENDITORI: " + JSON.stringify(this.allRivenditori));
      return data;
    })
  }
}
