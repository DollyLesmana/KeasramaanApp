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
public interface AsramaService {
	//saveOrUpdate digunakan untuk method save dan update
	Asrama saveOrUpdate(Asrama Asrama);

	List<Asrama> listAsrama();

	void hapusAsrama(Integer Id);

	Asrama getId(Integer Id);
	
	Asrama getIdAsrama(Integer Id);

}