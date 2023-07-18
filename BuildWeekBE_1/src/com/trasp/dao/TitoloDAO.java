package com.trasp.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trasp.enums.Durata;
import com.trasp.model.rivenditori.Rivenditore;
import com.trasp.model.rivenditori.RivenditoreAutorizzato;
import com.trasp.model.titoli.Abbonamento;
import com.trasp.model.titoli.Biglietto;
import com.trasp.model.titoli.Tessera;
import com.trasp.util.JpaUtil;

public class TitoloDAO {

	private static final Logger log = LoggerFactory.getLogger(TitoloDAO.class);

	public static void emissioneBiglietto(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		Rivenditore r = RivenditoreDAO.findRivenditore(id);
		
		if (r instanceof RivenditoreAutorizzato) {
			RivenditoreAutorizzato ra = (RivenditoreAutorizzato) r;
			LocalTime currentTime = LocalTime.now();
			// rivenditore autorizzato
			if (currentTime.isAfter(ra.getOrariodiApertura()) && currentTime.isBefore(ra.getOrariodiChiusura())) {
				try {
					em.getTransaction().begin();
					Biglietto b = new Biglietto();
					b.setLuogodiAcquisto(r);
					em.persist(b);
					em.getTransaction().commit();
					log.info("Biglietto acquistato!!!");
				} catch (Exception ex) {
					em.getTransaction().rollback();

					log.error(ex.getMessage());
					throw ex;

				} finally {
					em.close();
				}
			} else {
				log.info("Rivenditore chiuso!!!.");
			}
			// distributore automatico
		} else {
			try {
				em.getTransaction().begin();
				Biglietto b = new Biglietto();
				b.setLuogodiAcquisto(r);
				em.persist(b);
				em.getTransaction().commit();
				log.info("Biglietto acquistato!!!");
			} catch (Exception ex) {
				em.getTransaction().rollback();

				log.error(ex.getMessage());
				throw ex;

			} finally {
				em.close();
			}
		}
	}
	
	public static Abbonamento saveAbbonamento(Abbonamento a) {
			EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
			try {
				em.getTransaction().begin();
				em.persist(a);
				em.getTransaction().commit();
				return a;
			} catch (Exception ex) {
				em.getTransaction().rollback();

				log.error(ex.getMessage());
				throw ex;

			} finally {
				em.close();
			}

	}
	
	public static void caricaAbbonamento(long id, long nTessera, Durata durata) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			Rivenditore r = RivenditoreDAO.findRivenditore(id);
			Tessera t = em.find(Tessera.class, nTessera);
			em.getTransaction().begin();
			Abbonamento a = new Abbonamento();
			a.setTessera(t);
			a.setDurata(durata);
				switch(durata) {
				case SETTIMANALE:
					a.setDatadiScadenza(LocalDate.now().plusDays(7));
					break;
				case MENSILE:
					a.setDatadiScadenza(LocalDate.now().plusMonths(1));
					break;
				default:
					a.setDatadiScadenza(LocalDate.now());
				}
			a.setLuogodiAcquisto(r);
			Abbonamento aD = saveAbbonamento(a);
			t.setAbbonamento(aD);
			em.merge(t);
			em.getTransaction().commit();
			log.info("Abbonamento caricato!!!");
			}catch (Exception e) {
				em.getTransaction().rollback();
				log.error("Abbonamento non caricato" + e.getMessage());
				throw e;
			}finally{
				em.close();
			}

	}

	public static void deleteAbbonamento(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.remove(em.find(Abbonamento.class, id));
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			log.error("Error deleting" + e);
			throw e;

		} finally {
			em.close();
		}

	}
}
