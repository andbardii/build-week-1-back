import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Rivenditore } from '../Models/rivenditore';

@Injectable({
  providedIn: 'root'
})
export class DirigenteService {

  rivenditoreApi: string = environment.rivenditoreApi;
  constructor(private http: HttpClient) {}

  create(r: Rivenditore) {
    return this.http.post(this.rivenditoreApi, r);
  }

  getAll() {
    return this.http.get(this.rivenditoreApi);
  }
}
