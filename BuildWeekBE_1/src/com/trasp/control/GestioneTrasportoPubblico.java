package com.trasp.control;

import java.time.LocalDate;

import com.trasp.dao.MezzoDAO;
import com.trasp.dao.TitoloDAO;
import com.trasp.dao.TrattaDAO;

public class GestioneTrasportoPubblico {

//		### READ ME ###
//		( GestioneTest ) PERMETTE DI GENERARE DIVERSI DATI PER TESTARE IL PROGRAMMA
//		( ClassiDAO ) ESISTE UNA CLASSE DAO DEFINITA PER QUASI OGNI CLASSE: 
//		[ UTENTE, TITOLO, TESSERA, RIVENDITORE, MEZZO ]
	
	public static void main(String[] args) {

//		### GENERA 2 RIVENDITORI AUTORIZZATI E 1 DISTRIBUTORE AUTOMATICO ###
//		GestioneTest.generaRivenditori();
		
//		### GENERA 8 BIGLIETTI DAI 3 RIVENDITORI ###
//		GestioneTest.emettiBiglietti();
		
//		### CHIEDE NOME E COGNOME PER GENERARE 3 TESSERE ###
//		GestioneTest.emettiTessere();
		
//		### CARICA 1 ABBONAMENTO MENSILE E 2 SETTIMANALI NELLE TESSERE ###
//		GestioneTest.caricaAbbonamenti();
		
//		### GESTIONE TITOLI E UTENTI ###
//		TitoloDAO.checkAbbonamento(long NUMEROTESSERA)
//		TitoloDAO.rinnovaAbbonamento(long NUMEROTESSERA)
//		TitoloDAO.checkTessera(long NUMEROTESSERA)
//		TesseraDAO.rinnovaTessera(long NUMEROTESSERA);
		
//		TitoloDAO.findTitoliByRivenditore(1);
//		TitoloDAO.findTitoliByDate(LocalDate.of(2022, 7, 17), LocalDate.of(2022, 7, 19));
//		TitoloDAO.printAllTitoli();
		
//		### GESTIONE PARCO MEZZI ###
//		GestioneTest.caricaMezzi();
//		GestioneTest.caricaTratte();
		
//		MezzoDAO.entrainManutenzione(2);
//		MezzoDAO.entrainServizio(2);
		
//		MezzoDAO.vidimaBiglietto(4, 2);
//		MezzoDAO.findBigliettiByMezzo(2);
//		MezzoDAO.findBigliettiByValidationDate(LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 19));
//		MezzoDAO.checkStatoMezzo(1);
//		MezzoDAO.findManutenzioni(2);
	
//		TrattaDAO.assegnaTratta(1, 3);
//		TrattaDAO.assegnaTratta(7, 1);
//		TrattaDAO.checkTratteAssegnate(2);
		
	}
	
}
