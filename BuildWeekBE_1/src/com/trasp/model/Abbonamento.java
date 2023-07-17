package com.trasp.model;

import java.time.LocalDate;

import com.trasp.enums.Durata;

public class Abbonamento extends TitolodiViaggio {

	private Tessera tessera;
	private Durata durata;
	private LocalDate datadiScadenza;

	public Abbonamento() {
		super();
	}

	public Tessera getTessera() {
		return tessera;
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}

	public Durata getDurata() {
		return durata;
	}

	public void setDurata(Durata durata) {
		this.durata = durata;
	}
	
	public LocalDate getDatadiScadenza() {
		return datadiScadenza;
	}

	public void setDatadiScadenza(LocalDate datadiScadenza) {
		this.datadiScadenza = datadiScadenza;
	}

	@Override
	public String toString() {
		return "Abbonamento" + super.toString() + "tessera=" + tessera + ", durata=" + durata + ", datadiScadenza=" + datadiScadenza + "]";
	}

	

}
