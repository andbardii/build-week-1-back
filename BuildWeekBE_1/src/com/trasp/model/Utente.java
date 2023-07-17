package com.trasp.model;

public class Utente {

	private Long id;
	private String nome;
	private String cognome;
	private Tessera tessera;

	public Utente() {
		super();
	}

	public Utente(Long id, String nome, String cognome, Tessera tessera) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.tessera = tessera;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Tessera getTessera() {
		return tessera;
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", tessera=" + tessera + "]";
	}

}
