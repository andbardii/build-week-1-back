import { Injectable } from '@angular/core';
import { Utente } from '../Models/utente';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Tessera } from '../Models/tessera';
import { Biglietto } from '../Models/biglietto';
import { Abbonamento } from '../Models/abbonamento';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  utenteApi: string = environment.utenteApi;
  tesseraApi: string = environment.tesseraApi;
  bigliettoApi: string = environment.bigliettoApi;
  abbonamentoApi: string = environment.abbonamentoApi;

  constructor(private http: HttpClient) {}

  createTessera(t: Tessera) {
    return this.http.post(this.tesseraApi, t);
  }
  createUtente(u: Utente) {
    return this.http.post(this.utenteApi,u);
  }
  getAllTessere() {
    return this.http.get(this.tesseraApi);
  }
  sellBiglietto(b: Biglietto) {
    return this.http.post(this.bigliettoApi, b);
  }
  getAllBiglietti() {
    return this.http.get(this.bigliettoApi);
  }
  sellAbbonamento(a: Abbonamento) {
    return this.http.post(this.abbonamentoApi, a);
  }
  getAllAbbonamenti() {
    return this.http.get(this.abbonamentoApi);
  }
}
