import { Rivenditore } from 'src/app/Models/rivenditore';
import { Abbonamento } from './../../Models/abbonamento';
import { Component } from '@angular/core';
import { Tessera } from 'src/app/Models/tessera';
import { Utente } from 'src/app/Models/utente';
import { ClienteService } from 'src/app/Services/cliente.service';
import { Biglietto } from 'src/app/Models/biglietto';
import { DirigenteService } from 'src/app/Services/dirigente.service';
import { Durata } from 'src/app/Enums/durata';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.scss']
})
export class ClienteComponent {

  tf: any;

  durataScelta!: Durata;
  opzioniDurata: Durata[] = Object.values(Durata);


  u: Utente = {
    nome: '',
    cognome: ''
  }
  t: Tessera = {
    utente: this.u,
    datadiScadenza: new Date().setFullYear(new Date().getFullYear() + 1)
  }
  r: Rivenditore = {
    id: 0,
    nome: ''
  }
  a: Abbonamento = {
    datadiEmissione: new Date().getDate(),
    luogodiAcquisto: this.r,
    tessera: this.t,
    durata: this.durataScelta,
    datadiScadenza: 0
  }
  b: Biglietto = {
    datadiEmissione: new Date().getDate(),
    luogodiAcquisto: this.r
  }
  constructor(private cSvc:ClienteService, private dSvc:DirigenteService) {}

  iscriviUtente():void {
    this.cSvc.createUtente(this.u).subscribe(data => {
      console.log("UTENTE GENERATO" + data);
    })
    this.cSvc.createTessera(this.t).subscribe(data => {
      console.log("TESSERA GENERATA" + data);
      this.tf = data;
    })
  }
  sellBiglietto():void {
    this.dSvc.getRivenditoreById(this.r.id).subscribe(data => {
      this.r = <Rivenditore>data;
    })
    this.cSvc.sellBiglietto(this.b).subscribe(data => {
      console.log("BIGLIETTO VENDUTO" + data);
    })
  }
  sellAbbonamento():void {
    this.dSvc.getRivenditoreById(this.r.id).subscribe(data => {
      this.r = <Rivenditore>data;
    })
    if(this.a.durata == Durata.MENSILE){
      this.a.datadiScadenza = new Date().setMonth(new Date().getMonth() + 1);
    }else{
      this.a.datadiScadenza = new Date(new Date().getTime() + (7 * 24 * 60 * 60 * 1000)).getDate();;
    }
    this.cSvc.sellBiglietto(this.b).subscribe(data => {
      console.log("BIGLIETTO VENDUTO" + data);
    })
  }
}
