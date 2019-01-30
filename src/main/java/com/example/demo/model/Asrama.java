/*
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
//@Table(name="Asrama")
public class Asrama{
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;
		
		
		@Column(name="nama_asrama")
		public String nama_asrama;
		
		@Column(name="nama_pengurus_asrama")
		public String nama_pengurus_asrama;
		
		public String img;
		

		public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNama_asrama() {
			return nama_asrama;
		}

		public void setNama_asrama(String nama_asrama) {
			this.nama_asrama = nama_asrama;
		}

		public String getNama_pengurus_asrama() {
			return nama_pengurus_asrama;
		}

		public void setNama_pengurus_asrama(String nama_pengurus_asrama) {
			this.nama_pengurus_asrama = nama_pengurus_asrama;
		}
		
}