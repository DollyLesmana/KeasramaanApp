package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.demo.services.MahasiswaService;
import com.example.demo.model.*;

@Controller
public class MahasiswaController {
	
	
	private MahasiswaService mahasiswaService;
	
	//karena diinjeksi menggunakan setter maka diberikan autowired
	@Autowired
	public void setMahasiswaService(MahasiswaService mahasiswaService) {
		this.mahasiswaService = mahasiswaService;
	}
	@RequestMapping("/mahasiswa")
	public String MahasiswaList(Model model) {
		model.addAttribute("mahasiswa", mahasiswaService.listMahasiswa());
		return"mahasiswa";
	}
	
	@RequestMapping(value= "/mahasiswa/create", method = RequestMethod.GET)
	public String tampilkanForm(Model model) {
		model.addAttribute("mahasiswa", new Mahasiswa());
		return "formMahasiswa";
	}
	
	@RequestMapping(value = "/mahasiswa/create", method = RequestMethod.POST)
	public String simpanDataMahasiswa(Model model, Mahasiswa mahasiswa) {
		model.addAttribute("mahasiswa", mahasiswaService.saveOrUpdate(mahasiswa));
		return "redirect:/mahasiswa";
	}
	
	@RequestMapping(value = "/mahasiswa/hapus/{Id}", method = RequestMethod.GET)
	public String hapusMahasiswa(@PathVariable Integer Id) {
		mahasiswaService.hapusMahasiswa(Id);
		return "redirect:/mahasiswa";
	}
	
	@RequestMapping(value= "/mahasiswa/edit/{Id}", method = RequestMethod.GET)
	public String updateMahasiswa(@PathVariable Integer Id, Model model) {
		model.addAttribute("mahasiswa", mahasiswaService.getId(Id));
		return"formMahasiswa";
	}
}
