package com.trasp.dao;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trasp.model.rivenditori.Rivenditore;
import com.trasp.util.JpaUtil;

public class RivenditoreDAO {

	private static final Logger log = LoggerFactory.getLogger(TitoloDAO.class);
	
	public static void saveRivenditore(Rivenditore r) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(r);
			em.getTransaction().commit();
			log.info("Rivenditore aggiunto!!!");
		} catch (Exception ex) {
			em.getTransaction().rollback();

			log.error(ex.getMessage());
			throw ex;

		} finally {
			em.close();
		}
	}

	public static Rivenditore findRivenditore(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			Rivenditore r = em.find(Rivenditore.class, id);
			em.getTransaction().commit();
			log.info("Rivenditore aggiunto!!!");
			return r;
		} catch (Exception ex) {
			em.getTransaction().rollback();

			log.error(ex.getMessage());
			throw ex;

		} finally {
			em.close();
		}
	}




}
