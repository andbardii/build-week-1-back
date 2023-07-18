package com.trasp.control;

import com.trasp.dao.RivenditoreDAO;
import com.trasp.dao.TitoloDAO;
import com.trasp.enums.TipologiadiRivenditori;
import com.trasp.model.rivenditori.RivenditoreAutorizzato;

public class GestioneTrasportoPubblico {

	public static void main(String[] args) {

		RivenditoreAutorizzato ra1 = new RivenditoreAutorizzato();
//		ra1.setNome("Da Mario");
//		ra1.setTipoRivenditore(TipologiadiRivenditori.EDICOLA);
//		RivenditoreDAO.saveRivenditore(ra1);
		
		TitoloDAO.emissioneBiglietto(1);
	}

}
