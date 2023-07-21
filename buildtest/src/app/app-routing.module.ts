import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteComponent } from './Pages/cliente/cliente.component';
import { DirigenteComponent } from './Pages/dirigente/dirigente.component';
import { HomeComponent } from './Pages/home/home.component';
import { MacchinistaComponent } from './Pages/macchinista/macchinista.component';

const routes: Routes = [
  {path: 'cliente', component:ClienteComponent},
  {path: 'dirigente', component:DirigenteComponent},
  {path: 'macchinista', component:MacchinistaComponent},
  {path: '', component:HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
