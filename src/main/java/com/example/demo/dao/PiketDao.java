/**
 * 
 */
/**
 * @author Dolly Lesmana Lubis
 *
 */
package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Piket;
import com.example.demo.services.PiketService;



@Service
public class PiketDao implements PiketService {
	
	private EntityManagerFactory emf;
	
	//Injection menggunakan setter
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	//Membutuhkan ijeksi EntityManagerFactory
	@Override
	public List<Piket> listPiket() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Piket", Piket.class).getResultList();
	}

	@Override
	public List<Piket> listPiket(Integer asrama) {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Piket p where p.asrama IN :asrama", Piket.class)
				.setParameter("asrama", asrama)
				.getResultList();
	}
	
	@Override
	public Piket saveOrUpdate(Piket Piket) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Piket saved = em.merge(Piket);
		em.getTransaction().commit();
		return saved;
	}
	
	@Override
	public void hapusPiket(Integer Id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Piket.class,Id));
		em.getTransaction().commit();
	}
	
	@Override
	public Piket getId(Integer Id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Piket.class, Id);
	}
	
	@Override
	public Piket getIdPiket(Integer Id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Piket.class, Id);
	}
	
	@Override
	public Piket DetailPiket(Integer Id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Piket.class,  Id);
	}
}
