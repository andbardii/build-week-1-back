package com.trasp.model;

import java.time.LocalDate;

public class Tessera {

	private Long numeroTessera;
	private Utente utente;
	private Abbonamento abbonamento;
	private LocalDate datadiScadenza;

	public Tessera() {
		super();
	}

	public Tessera(Long numeroTessera, Utente utente, Abbonamento abbonamento, LocalDate datadiScadenza) {
		super();
		this.numeroTessera = numeroTessera;
		this.utente = utente;
		this.abbonamento = abbonamento;
		this.datadiScadenza = datadiScadenza;
	}

	public Long getNumeroTessera() {
		return numeroTessera;
	}

	public void setNumeroTessera(Long numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Abbonamento getAbbonamento() {
		return abbonamento;
	}

	public void setAbbonamento(Abbonamento abbonamento) {
		this.abbonamento = abbonamento;
	}

	public LocalDate getDatadiScadenza() {
		return datadiScadenza;
	}

	public void setDatadiScadenza(LocalDate datadiScadenza) {
		this.datadiScadenza = datadiScadenza;
	}

	@Override
	public String toString() {
		return "Tessera [numeroTessera=" + numeroTessera + ", utente=" + utente + ", abbonamento=" + abbonamento
				+ ", datadiScadenza=" + datadiScadenza + "]";
	}

}
