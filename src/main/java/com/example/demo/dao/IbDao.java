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

import com.example.demo.model.Ib;
import com.example.demo.services.IbService;



@Service
public class IbDao implements IbService {
	
	private EntityManagerFactory emf;
	
	//Injection menggunakan setter
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	//Membutuhkan ijeksi EntityManagerFactory
	@Override
	public List<Ib> listIb() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Ib", Ib.class).getResultList();
	}
	
	@Override
	public Ib saveOrUpdate(Ib Ib) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Ib saved = em.merge(Ib);
		em.getTransaction().commit();
		return saved;
	}
	
	@Override
	public void hapusIb(Integer Id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Ib.class,Id));
		em.getTransaction().commit();
	}
	
	@Override
	public Ib getId(Integer Id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Ib.class, Id);
	}
	
	@Override
	public Ib getIdIb(Integer Id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Ib.class, Id);
	}
	
}
