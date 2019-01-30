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

import com.example.demo.model.Ik;
import com.example.demo.services.IkService;



@Service
public class IkDao implements IkService {
	
	private EntityManagerFactory emf;
	
	//Injection menggunakan setter
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	//Membutuhkan ijeksi EntityManagerFactory
	@Override
	public List<Ik> listIk() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Ik", Ik.class).getResultList();
	}
	
	@Override
	public Ik saveOrUpdate(Ik Ik) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Ik saved = em.merge(Ik);
		em.getTransaction().commit();
		return saved;
	}
	
	@Override
	public void hapusIk(Integer Id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Ik.class,Id));
		em.getTransaction().commit();
	}
	
	@Override
	public Ik getId(Integer Id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Ik.class, Id);
	}
	
	@Override
	public Ik getIdIk(Integer Id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Ik.class, Id);
	}
	
}
