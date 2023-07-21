import { Rivenditore } from "./rivenditore";

export interface Biglietto {
  id?: number;
  datadiEmissione: number;
  luogodiAcquisto: Rivenditore;
  datadiValidazione?: number;
}

