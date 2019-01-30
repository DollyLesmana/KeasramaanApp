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

import com.example.demo.model.Mahasiswa;
import com.example.demo.services.MahasiswaService;



@Service
public class MahasiswaDao implements MahasiswaService {
	
	private EntityManagerFactory emf;
	
	//Injection menggunakan setter
	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	//Membutuhkan ijeksi EntityManagerFactory
	@Override
	public List<Mahasiswa> listMahasiswa() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Mahasiswa", Mahasiswa.class).getResultList();
	}
	
	@Override
	public Mahasiswa saveOrUpdate(Mahasiswa mahasiswa) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Mahasiswa saved = em.merge(mahasiswa);
		em.getTransaction().commit();
		return saved;
	}
	
	@Override
	public void hapusMahasiswa(Integer Id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Mahasiswa.class,Id));
		em.getTransaction().commit();
	}
	
	@Override
	public Mahasiswa getId(Integer Id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Mahasiswa.class, Id);
	}
	
	@Override
	public Mahasiswa getIdMahasiswa(Integer Id) {
		EntityManager em = emf.createEntityManager();
		return em.find(Mahasiswa.class, Id);
	}
	
}
