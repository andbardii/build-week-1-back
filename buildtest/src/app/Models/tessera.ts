import { Abbonamento } from './abbonamento';
import { Utente } from "./utente";

export interface Tessera {
  numeroTessera?: number;
  utente: Utente;
  abbonamento?: Abbonamento;
  datadiScadenza: number;
}
