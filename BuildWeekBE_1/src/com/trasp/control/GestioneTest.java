package com.trasp.control;

import com.trasp.dao.TitoloDAO;
import com.trasp.dao.RivenditoreDAO;
import com.trasp.dao.TesseraDAO;
import com.trasp.enums.Durata;
import com.trasp.enums.TipologiadiRivenditori;
import com.trasp.model.rivenditori.DistributoreAutomatico;
import com.trasp.model.rivenditori.RivenditoreAutorizzato;

public class GestioneTest {
	
//	### CLASSE PER TESTARE IL PROGRAMMA ###

	public static void emettiBiglietti() {
		
//		PER GENERARE UN BIGLIETTO ABBIAMO BIOSOGNO DELL'ID DEL RIVENDITORE 
//		CHE LO HA VEDUTO, GLI ALTRI DATI VENGONO GENERATI AUTOMATICAMENTE
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
		
//		PER GENERARE UN RIVENTIRORE AUTORIZZATO ABBIAMO BIOSOGNO DI INSERIRE IL NOME 
//		E LA TIPOLOGIA [ EDICOLA, TABACCHI, SUPERMERCATO ]
		RivenditoreAutorizzato ra1 = new RivenditoreAutorizzato();
		ra1.setNome("Da Mario");
		ra1.setTipoRivenditore(TipologiadiRivenditori.EDICOLA);
		RivenditoreDAO.saveRivenditore(ra1);
		
		RivenditoreAutorizzato ra2 = new RivenditoreAutorizzato();
		ra2.setNome("Da Maria");
		ra2.setTipoRivenditore(TipologiadiRivenditori.TABACCHI);
		RivenditoreDAO.saveRivenditore(ra2);
		
//		PER GENERARE UN DISTRIBUTORE AUTOMATICO ABBIAMO BIOSOGNO DI INSERIRE IL NOME 
		DistributoreAutomatico da1 = new DistributoreAutomatico();
		da1.setNome("H24 Merendine");
		RivenditoreDAO.saveRivenditore(da1);
		
	}
	
	public static void emettiTessere() {
		
//		PER GENERARE UNA TESSERA E UN UTENTE CHIEDIAMO ALL'UTENTE NOME E COGNOME 
//		SUCCESSIVAMENTE GLI MOSTRIAMO IL NUMERO DELLA SUA TESSERA
		TesseraDAO.emissioneTessera();
		TesseraDAO.emissioneTessera();
		TesseraDAO.emissioneTessera();
	}
	
	public static void caricaAbbonamenti() {
		
//		PER VENDERE UN ABBONAMENTO ABBIAMO BISOGNO DELL'ID DEL RIVENDITORE, 
//		IL NUMERO DELLA TESSERA DEL CLIENTE E DELLA DURATA DELL'ABBONAMENTO
		TitoloDAO.caricaAbbonamento(1, 1, Durata.MENSILE);
		TitoloDAO.caricaAbbonamento(2, 2, Durata.SETTIMANALE);
		TitoloDAO.caricaAbbonamento(2, 3, Durata.SETTIMANALE);
		
	}
}
