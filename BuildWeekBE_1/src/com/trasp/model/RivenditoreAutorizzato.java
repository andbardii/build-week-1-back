package com.trasp.model;

import java.time.LocalTime;

import com.trasp.enums.TipoRivenditore;

public class RivenditoreAutorizzato extends Rivenditore {

	private TipoRivenditore tipoRivenditore;
	private final LocalTime orariodiApertura = LocalTime.of(9, 0);
	private final LocalTime orariodiChiusura = LocalTime.of(21, 0);

	public RivenditoreAutorizzato() {
		super();
	}

	public RivenditoreAutorizzato(TipoRivenditore tipoRivenditore) {
		super();
		this.tipoRivenditore = tipoRivenditore;
	}

	public TipoRivenditore getTipoRivenditore() {
		return tipoRivenditore;
	}

	public void setTipoRivenditore(TipoRivenditore tipoRivenditore) {
		this.tipoRivenditore = tipoRivenditore;
	}

	public LocalTime getOrariodiApertura() {
		return orariodiApertura;
	}

	public LocalTime getOrariodiChiusura() {
		return orariodiChiusura;
	}

	@Override
	public String toString() {
		return "RivenditoreAutorizzato" + super.toString() + "tipoRivenditore=" + tipoRivenditore
				+ ", orariodiApertura=" + orariodiApertura + ", orariodiChiusura=" + orariodiChiusura + "]";
	}

}
