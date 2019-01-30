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
public interface PerizinanService {
	//saveOrUpdate digunakan untuk method save dan update
	Perizinan saveOrUpdate(Perizinan perizinan);

	List<Perizinan> listPerizinan();

	void hapusPerizinan(Integer Id);
	
	Perizinan DeteilPerizinan(Integer Id);

	Perizinan getId(Integer Id);
	
	Perizinan getIdPerizinan(Integer Id);
}	