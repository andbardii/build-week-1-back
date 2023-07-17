package com.trasp.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public abstract class Mezzo {

	private Long id;
	private int capienza;
	private Map<LocalDate, LocalDate> inManutenzione;
	private Map<LocalDate, LocalDate> inServizio;
	private List<Tratta> tratta;

	public Mezzo() {
		super();
	}

	public Mezzo(int capienza, Map<LocalDate, LocalDate> inManutenzione, Map<LocalDate, LocalDate> inServizio,
			List<Tratta> tratta) {
		super();
		this.capienza = capienza;
		this.inManutenzione = inManutenzione;
		this.inServizio = inServizio;
		this.tratta = tratta;
	}

	public int getCapienza() {
		return capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public Map<LocalDate, LocalDate> getInManutenzione() {
		return inManutenzione;
	}

	public void setInManutenzione(Map<LocalDate, LocalDate> inManutenzione) {
		this.inManutenzione = inManutenzione;
	}

	public Map<LocalDate, LocalDate> getInServizio() {
		return inServizio;
	}

	public void setInServizio(Map<LocalDate, LocalDate> inServizio) {
		this.inServizio = inServizio;
	}

	public List<Tratta> getTratta() {
		return tratta;
	}

	public void setTratta(List<Tratta> tratta) {
		this.tratta = tratta;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Mezzo [id=" + id + ", capienza=" + capienza + ", inManutenzione=" + inManutenzione + ", inServizio="
				+ inServizio + ", tratta=" + tratta + "]";
	}

}
