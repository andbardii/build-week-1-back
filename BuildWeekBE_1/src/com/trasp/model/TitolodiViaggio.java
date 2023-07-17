package com.trasp.model;

import java.time.LocalDate;

public abstract class TitolodiViaggio {

	private Long id;
	private boolean valido;
	private LocalDate datadiEmissione;
	private Rivenditore luogodiAcquisto;

	public TitolodiViaggio() {
		super();
	}

	public Long getId() {
		return id;
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public LocalDate getDatadiEmissione() {
		return datadiEmissione;
	}

	public void setDatadiEmissione(LocalDate datadiEmissione) {
		this.datadiEmissione = datadiEmissione;
	}

	public Rivenditore getLuogodiAcquisto() {
		return luogodiAcquisto;
	}

	public void setLuogodiAcquisto(Rivenditore luogodiAcquisto) {
		this.luogodiAcquisto = luogodiAcquisto;
	}

}
