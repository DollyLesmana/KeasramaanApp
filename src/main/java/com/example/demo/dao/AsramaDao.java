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

import com.example.demo.model.Asrama;
import com.example.demo.services.AsramaService;



@Service
public class AsramaDao implements AsramaService {
	
	private EntityManagerFactory emf;
	
	//Injection menggunakan setter
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	//Membutuhkan ijeksi EntityManagerFactory
	@Override
	public List<Asrama> listAsrama() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Asrama", Asrama.class).getResultList();
	}
	
	@Override
	public Asrama saveOrUpdate(Asrama Asrama) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Asrama saved = em.merge(Asrama);
		em.getTransaction().commit();
		return saved;
	}
	
	@Override
	public void hapusAsrama(Integer Id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Asrama.class,Id));
		em.getTransaction().commit();
	}
	
	@Override
	public Asrama getId(Integer Id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Asrama.class, Id);
	}
	
	@Override
	public Asrama getIdAsrama(Integer Id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Asrama.class, Id);
	}
	
}
