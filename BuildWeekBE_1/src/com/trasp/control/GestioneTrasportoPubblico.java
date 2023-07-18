package com.trasp.control;

import com.trasp.dao.RivenditoreDAO;
import com.trasp.dao.TitoloDAO;
import com.trasp.enums.Durata;
import com.trasp.enums.TipologiadiRivenditori;
import com.trasp.model.rivenditori.DistributoreAutomatico;
import com.trasp.model.rivenditori.RivenditoreAutorizzato;

public class GestioneTrasportoPubblico {

	public static void main(String[] args) {

//		GENERA CONTENUTI NEL DATABASE
		
//		GestioneTest.generaRivenditori();
//		GestioneTest.emettiBiglietti();
//		GestioneTest.emettiTessere();
		
//		TitoloDAO.caricaAbbonamento(1, 2, Durata.MENSILE);
		TitoloDAO.deleteAbbonamento(10);
		
	}
	
	
}
