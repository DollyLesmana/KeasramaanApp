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
public interface PiketService {
	//saveOrUpdate digunakan untuk method save dan update
	Piket saveOrUpdate(Piket piket);

	List<Piket> listPiket();
	
	List<Piket> listPiket(Integer asrama);

	void hapusPiket(Integer Id);
	
	Piket DetailPiket(Integer Id);

	Piket getId(Integer Id);
	
	Piket getIdPiket(Integer Id);
}	