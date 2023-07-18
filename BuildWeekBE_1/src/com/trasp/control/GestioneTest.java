package com.trasp.control;

import com.trasp.dao.RivenditoreDAO;
import com.trasp.dao.TesseraDAO;
import com.trasp.dao.TitoloDAO;
import com.trasp.enums.TipologiadiRivenditori;
import com.trasp.model.rivenditori.DistributoreAutomatico;
import com.trasp.model.rivenditori.RivenditoreAutorizzato;

public class GestioneTest {
	
//	CLASSE PER TESTARE IL PROGRAMMA

	public static void emettiBiglietti() {
		TitoloDAO.emissioneBiglietto(1);
		TitoloDAO.emissioneBiglietto(1);
		TitoloDAO.emissioneBiglietto(2);
		TitoloDAO.emissioneBiglietto(2);
		TitoloDAO.emissioneBiglietto(3);
		TitoloDAO.emissioneBiglietto(3);
		TitoloDAO.emissioneBiglietto(2);
		TitoloDAO.emissioneBiglietto(3);
	}

	public static void generaRivenditori() {
		
		RivenditoreAutorizzato ra1 = new RivenditoreAutorizzato();
		ra1.setNome("Da Mario");
		ra1.setTipoRivenditore(TipologiadiRivenditori.EDICOLA);
		RivenditoreDAO.saveRivenditore(ra1);
		
		RivenditoreAutorizzato ra2 = new RivenditoreAutorizzato();
		ra2.setNome("Da Maria");
		ra2.setTipoRivenditore(TipologiadiRivenditori.TABACCHI);
		RivenditoreDAO.saveRivenditore(ra2);
		
		DistributoreAutomatico da1 = new DistributoreAutomatico();
		da1.setNome("H24 Merendine");
		RivenditoreDAO.saveRivenditore(da1);
		
	}
	
	public static void emettiTessere() {
		
		TesseraDAO.emissioneTessera();
		TesseraDAO.emissioneTessera();
		TesseraDAO.emissioneTessera();
	}
	
	public static void caricaAbbonamenti() {
		
		
	}
}
