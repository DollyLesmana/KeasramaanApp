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
public interface PengumumanService {
	//saveOrUpdate digunakan untuk method save dan update
	Pengumuman saveOrUpdate(Pengumuman Pengumuman);

	List<Pengumuman> listPengumuman();

	void hapusPengumuman(Integer Id);
	
	Pengumuman DetailPengumuman(Integer Id);

	Pengumuman getId(Integer Id);
	
	Pengumuman getIdPengumuman(Integer Id);
}	