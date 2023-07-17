package com.trasp.model;

public class Tratta {
	
	private Long id;
	private String nome;
	private int tempoDiPercorrenza;
	private String capolinea;
	
	public Tratta() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTempoDiPercorrenza() {
		return tempoDiPercorrenza;
	}

	public void setTempoDiPercorrenza(int tempoDiPercorrenza) {
		this.tempoDiPercorrenza = tempoDiPercorrenza;
	}

	public String getCapolinea() {
		return capolinea;
	}

	public void setCapolinea(String capolinea) {
		this.capolinea = capolinea;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Tratta [id=" + id + ", nome=" + nome + ", tempoDiPercorrenza=" + tempoDiPercorrenza + ", capolinea="
				+ capolinea + "]";
	}
	

}
