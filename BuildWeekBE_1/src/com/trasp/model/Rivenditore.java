package com.trasp.model;

public abstract class Rivenditore {
	
	private Long id;
	private String nome;
	
	public Rivenditore() {
		super();
	}

	public Rivenditore(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

}
