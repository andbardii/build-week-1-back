package com.trasp.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trasp.enums.StatodeiMezzi;
import com.trasp.model.mezzi.Autobus;
import com.trasp.model.mezzi.Mezzo;
import com.trasp.model.mezzi.Tratta;
import com.trasp.model.mezzi.TrattaAssegnata;
import com.trasp.model.titoli.Biglietto;
import com.trasp.model.titoli.TitolodiViaggio;
import com.trasp.util.JpaUtil;

public class TrattaDAO {
	
	private static Scanner scan = new Scanner(System.in);
	private static final Logger log = LoggerFactory.getLogger(TrattaDAO.class);
	
	public static Tratta saveTratta(Tratta t) {
		
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			return t;
		} catch (Exception ex) {
			em.getTransaction().rollback();
			log.error(ex.getMessage());
			throw ex;

		} finally {
			em.close();
		}
		
	}
	
	public static void assegnaTratta(long id, long idT) {
		
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			Mezzo m = em.find(Mezzo.class, id);
			Tratta t = em.find(Tratta.class, idT);
			TrattaAssegnata ta = new TrattaAssegnata();
			em.persist(ta);
			ta.setTratta(t);
			m.getTratta().add(ta);
			em.merge(m);
			em.getTransaction().commit();
			log.info("Tratta assegnata!!!");
		} catch (Exception ex) {
			em.getTransaction().rollback();
			log.error(ex.getMessage());
			throw ex;
		} finally {
			em.close();
		}
		
	}
	
	public static void dichiaraTempoEffettivo(long id, double tempo) {
		
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			em.getTransaction().begin();
			TrattaAssegnata t = em.find(TrattaAssegnata.class, id);
			if(t.getTempoEffettivo() == 0) {
				t.setTempoEffettivo(tempo);
				em.merge(t);
				em.getTransaction().commit();
				if(t.getTempoEffettivo() > t.getTratta().getTempoMedio()) {
					log.info("Il tuo tempo è superiore al tempo medio!!!");
				}else {
					log.info("Hai rispettato i tempi!!!");
				}
			}else {
				log.info("Hai già dichiarato il tempo effettivo!!!");
			}
		} catch (Exception ex) {
			em.getTransaction().rollback();
			log.error(ex.getMessage());
			throw ex;
		} finally {
			em.close();
		}
		
	}

	public static void checkTratteAssegnate(long id) {
		
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			Mezzo m = em.find(Mezzo.class, id);
			em.getTransaction().commit();
			List<TrattaAssegnata> risultato = m.getTratta();
			boolean first = true;
			for(TrattaAssegnata t : risultato) {
				if(first) {
					log.info("Tratte assegnate: ");
					log.info(t.toString());			
				}else {
					log.info(t.toString());
				}
				first = false;
			}
		} catch (Exception ex) {
			em.getTransaction().rollback();

			log.error(ex.getMessage());
			throw ex;

		} finally {
			em.close();
		}
		
	}
	
	public static void findRipetizioniTratta (long idM, long idT) {
		
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		
		try {
			
        Query query = em.createNamedQuery("findRipetizioniTratta", TrattaAssegnata.class);
        query.setParameter("idTratta", idT);
        List<TrattaAssegnata> risultato = query.getResultList();
        em.getTransaction().begin();
		Mezzo m = em.find(Mezzo.class, idM);
		Tratta tratta = em.find(Tratta.class, idT);
		em.getTransaction().commit();
        int n = 0;
        
        for(TrattaAssegnata t : risultato) {
        	for(TrattaAssegnata tA : m.getTratta()) {
        		if(t.getId() == tA.getId()) {
        			n++;
        		}
        	}
		}
        
        if(risultato.size()==0) {
        	log.info("Nessun risultato trovato!!!");
        }else if(n != 0) {
        	log.info("Il mezzo con id " + m.getId() + " ha percorso la tratta " + tratta.getNome() + " " + n + " volte!!!");
        }else {
        	log.info("Il mezzo non ha percorso la tratta indicata!!!");
        }
		}catch (Exception ex) {
			em.getTransaction().rollback();

			log.error(ex.getMessage());
			throw ex;

		} finally {
			em.close();
		}
		
	}

	

}
