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
public interface IbService {
	//saveOrUpdate digunakan untuk method save dan update
	Ib saveOrUpdate(Ib Ib);

	List<Ib> listIb();

	void hapusIb(Integer Id);

	Ib getId(Integer Id);
	
	Ib getIdIb(Integer Id);

}