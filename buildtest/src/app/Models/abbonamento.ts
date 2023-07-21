import { Durata } from './../Enums/durata';
import { Tessera } from './tessera';
import { Rivenditore } from "./rivenditore";

export interface Abbonamento {
  id?: number;
  datadiEmissione: number;
  luogodiAcquisto: Rivenditore;
  tessera: Tessera;
  durata: Durata;
  datadiScadenza: number;
}
