import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Rivenditore } from 'src/app/Models/rivenditore';
import { ClienteService } from 'src/app/Services/cliente.service';
import { DirigenteService } from 'src/app/Services/dirigente.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-dirigente',
  templateUrl: './dirigente.component.html',
  styleUrls: ['./dirigente.component.scss']
})
export class DirigenteComponent implements OnInit {
  nR:number = 0;
  nT:number = 0;
  nB:number = 0;

  allRivenditori:any;
  allTessere:any;
  allBiglietti:any;

   r: Rivenditore = {
    nome: ''
  }

  constructor(private dSvc:DirigenteService, private cSvc:ClienteService) {}

  ngOnInit(): void {
    this.countRivenditori();
    this.countBiglietti();
    this.countTessere();
  }
  generaRivenditore(): void {
    this.dSvc.create(this.r).subscribe(data => {
      console.log("RIVENDITORE GENERATO" + data);
    })

  }
  getAllRivenditori(): void {
    this.dSvc.getAll().subscribe(data => {
      this.allRivenditori = data;
      console.log("TOTALE RIVENDITORI: " + JSON.stringify(this.allRivenditori));
      return data;
    })
  }
  getAllTessere(): void {
    this.cSvc.getAllTessere().subscribe(data => {
      this.allRivenditori = data;
      console.log("TOTALE UTENTI ISCRITTI: " + JSON.stringify(this.allRivenditori));
      return data;
    })
  }
  countRivenditori(): void {
    for (let i = 0; i < this.allRivenditori.length; i++) {
      this.nR++;
    }
  }
  countTessere(): void {
    for (let i = 0; i < this.allTessere.length; i++) {
      this.nT++;
    }
  }
  countBiglietti(): void {
    for (let i = 0; i < this.allBiglietti.length; i++) {
      this.nB++;
    }
  }

}
