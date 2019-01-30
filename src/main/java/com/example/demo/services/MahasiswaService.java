/**
 * 
 */
/**
 
* @author Dolly Lesmana Lubis
 *
 */
package com.example.demo.services;

import com.example.demo.model.*;
import java.util.List;
public interface MahasiswaService {
	//saveOrUpdate digunakan untuk method save dan update
	Mahasiswa saveOrUpdate(Mahasiswa mahasiswa);

	List<Mahasiswa> listMahasiswa();

	void hapusMahasiswa(Integer Id);

	Mahasiswa getId(Integer Id);
	
	Mahasiswa getIdMahasiswa(Integer Id);

}