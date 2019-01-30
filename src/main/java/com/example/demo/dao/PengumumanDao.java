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

import com.example.demo.model.Pengumuman;
import com.example.demo.services.PengumumanService;



@Service
public class PengumumanDao implements PengumumanService {
	
	private EntityManagerFactory emf;
	
	//Injection menggunakan setter
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	//Membutuhkan ijeksi EntityManagerFactory
	@Override
	public List<Pengumuman> listPengumuman() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Pengumuman", Pengumuman.class).getResultList();
	}
	
	@Override
	public Pengumuman saveOrUpdate(Pengumuman Pengumuman) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Pengumuman saved = em.merge(Pengumuman);
		em.getTransaction().commit();
		return saved;
	}
	
	@Override
	public void hapusPengumuman(Integer Id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Pengumuman.class,Id));
		em.getTransaction().commit();
	}
	
	@Override
	public Pengumuman getId(Integer Id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Pengumuman.class, Id);
	}
	
	@Override
	public Pengumuman getIdPengumuman(Integer Id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Pengumuman.class, Id);
	}
	
	@Override
	public Pengumuman DetailPengumuman(Integer Id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Pengumuman.class,  Id);
	}
}
