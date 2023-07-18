package com.trasp.dao;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trasp.enums.StatodeiMezzi;
import com.trasp.model.mezzi.Manutenzione;
import com.trasp.model.mezzi.Mezzo;
import com.trasp.util.JpaUtil;

public class MezzoDAO {
	
	private static Scanner scan = new Scanner(System.in);
	private static final Logger log = LoggerFactory.getLogger(TesseraDAO.class);
	
	public static Mezzo saveMezzo(Mezzo m) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(m);
			em.getTransaction().commit();
			return m;
		} catch (Exception ex) {
			em.getTransaction().rollback();
			log.error(ex.getMessage());
			throw ex;

		} finally {
			em.close();
		}
	}

	public static void entrainManutenzione(long id) {
		
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			Mezzo m = em.find(Mezzo.class, id);
			if(m.getStatomezzo() == StatodeiMezzi.INMANUTENZIONE) {
				log.info("Mezzo gia in manutenzione!!!");
			}else {
				m.setStatomezzo(StatodeiMezzi.INMANUTENZIONE);
				Manutenzione mu = new Manutenzione();
				mu.setInizioManutenzione(LocalDate.now());
				em.persist(mu);
				m.getPeriodoDiManutenzione().add(mu);
				em.merge(m);
				log.info("Mezzo entrato in manutenzione!!!");
			}
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();

			log.error(ex.getMessage());
			throw ex;

		} finally {
			em.close();
		}
	}
	
	public static void  entrainServizio(long id) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			Mezzo m = em.find(Mezzo.class, id);
			if(m.getStatomezzo() == StatodeiMezzi.INSERVIZIO) {
				log.info("Mezzo gia in servizio!!!");
			}else {
				m.setStatomezzo(StatodeiMezzi.INSERVIZIO);
				long idm = m.getPeriodoDiManutenzione().get(m.getPeriodoDiManutenzione().size()-1).getId();
				Manutenzione mu = em.find(Manutenzione.class, idm);
				mu.setFineManutenzione(LocalDate.now());
				em.merge(mu);
				m.getPeriodoDiManutenzione().add(mu);
				em.merge(m);
				log.info("Mezzo entrato in servizio!!!");
			}
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();

			log.error(ex.getMessage());
			throw ex;

		} finally {
			em.close();
		}
	}
}
