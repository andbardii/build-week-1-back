package com.trasp.model;

import com.trasp.enums.StatodiServizio;

public class DistributoreAutomatico extends Rivenditore {

	private StatodiServizio status;

	public DistributoreAutomatico() {
		super();
	}

	public DistributoreAutomatico(StatodiServizio status) {
		super();
		this.status = status;
	}

	public StatodiServizio getStatus() {
		return status;
	}

	public void setStatus(StatodiServizio status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DistributoreAutomatico" + super.toString() + "status=" + status + "]";
	}
	
	
}
