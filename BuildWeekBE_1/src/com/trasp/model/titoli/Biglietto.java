package com.trasp.model.titoli;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.trasp.model.mezzi.Mezzo;

@Entity
public class Biglietto extends TitolodiViaggio {
	
	private LocalDate datadiValidazione;
	@ManyToOne
	private Mezzo luogodiValidazione;
	
	public Biglietto() {
		super();
	}

	public LocalDate getDatadiValidazione() {
		return datadiValidazione;
	}

	public void setDatadiValidazione(LocalDate datadiValidazione) {
		this.datadiValidazione = datadiValidazione;
	}

	public Mezzo getLuogodiValidazione() {
		return luogodiValidazione;
	}

	public void setLuogodiValidazione(Mezzo luogodiValidazione) {
		this.luogodiValidazione = luogodiValidazione;
	}

	@Override
	public String toString() {
		return "Biglietto" + super.toString() +" datadiValidazione=" + datadiValidazione + ", luogodiValidazione=" + luogodiValidazione + "]";
	}
	
	

}
