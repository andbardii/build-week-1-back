package com.trasp.dao;

import java.time.LocalTime;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trasp.model.rivenditori.Rivenditore;
import com.trasp.model.rivenditori.RivenditoreAutorizzato;
import com.trasp.model.titoli.Biglietto;
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
				log.info("Non siamo all'interno del range di orari specificato.");
			}
			// distributore automatico
		} else {
			try {
				em.getTransaction().begin();
				Biglietto b = new Biglietto();
				b.setLuogodiAcquisto(r);
				em.persist(b);
				em.getTransaction().commit();
				log.info("Biglietto acquistato!");
			} catch (Exception ex) {
				em.getTransaction().rollback();

				log.error(ex.getMessage());
				throw ex;

			} finally {
				em.close();
			}
		}
	}

}
