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
public interface IkService {
	//saveOrUpdate digunakan untuk method save dan update
	Ik saveOrUpdate(Ik Ik);

	List<Ik> listIk();

	void hapusIk(Integer Id);

	Ik getId(Integer Id);
	
	Ik getIdIk(Integer Id);

}