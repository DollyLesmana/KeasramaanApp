/**
 * 
 */
/**

 * @author Dolly Lesmana Lubis
 *
 */
package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name="Ib")
public class Ib{
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;
		
		
		@Column(name="tujuan")
		private String tujuan;
		
		@Column(name="tanggal_keberangkatan")
		private String tanggal_keberangkatan;
		
		@Column(name="tanggal_kepulangan")
		private String tanggal_kepulangan;
		
		@Column(name="persetujuan")
		private String persetujuan;
		
		
		public String getPersetujuan() {
			return persetujuan;
		}
		public void setPersetujuan(String persetujuan) {
			this.persetujuan = persetujuan;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getTujuan() {
			return tujuan;
		}
		public void setTujuan(String tujuan) {
			this.tujuan = tujuan;
		}
		public String getTanggal_keberangkatan() {
			return tanggal_keberangkatan;
		}
		public void setTanggal_keberangkatan(String tanggal_keberangkatan) {
			this.tanggal_keberangkatan = tanggal_keberangkatan;
		}
		public String getTanggal_kepulangan() {
			return tanggal_kepulangan;
		}
		public void setTanggal_kepulangan(String tanggal_kepulangan) {
			this.tanggal_kepulangan = tanggal_kepulangan;
		}
		
		
}