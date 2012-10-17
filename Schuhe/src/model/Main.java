package model;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


//hallo atilla
public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("Schuhe");
		EntityManager manager = emf.createEntityManager();
		
		EntityTransaction tx = manager.getTransaction();
		
		Query q = manager.createQuery("select m from Marke m");
		@SuppressWarnings("unchecked")
		List<Marke> a = q.getResultList();
		Query q2 = manager.createQuery("select m f rom Schuh m where m.marken is null");
		@SuppressWarnings("unchecked")
		List<Schuh> a2 = q2.getResultList();
		System.out.println("produkten marken:");
		
		tx.begin();
		Marke m = a.get(0);
		int i = 600;
		for (Schuh schuh : a2) {
			schuh.setMarken(m);
			System.out.println(schuh+" added");
		}
		
		
		//manager.persist(m);
		m=manager.merge(m);
		tx.commit();
		
		for(Marke p : a){
			System.out.println(p.toString());
		}
	}
}
