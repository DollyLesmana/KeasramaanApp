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

import com.example.demo.model.Perizinan;
import com.example.demo.services.PerizinanService;



@Service
public class PerizinanDao implements PerizinanService {
	
	private EntityManagerFactory emf;
	
	//Injection menggunakan setter
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	//Membutuhkan ijeksi EntityManagerFactory
	@Override
	public List<Perizinan> listPerizinan() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Perizinan", Perizinan.class).getResultList();
	}
	
	@Override
	public Perizinan saveOrUpdate(Perizinan Perizinan) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Perizinan saved = em.merge(Perizinan);
		em.getTransaction().commit();
		return saved;
	}
	
	@Override
	public void hapusPerizinan(Integer Id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Perizinan.class,Id));
		em.getTransaction().commit();
	}
	
	@Override
	public Perizinan getId(Integer Id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Perizinan.class, Id);
	}
	
	@Override
	public Perizinan getIdPerizinan(Integer Id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Perizinan.class, Id);
	}
	
	@Override
	public Perizinan DeteilPerizinan(Integer Id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Perizinan.class,  Id);
	}
}
