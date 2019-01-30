package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.services.PengumumanService;
import com.example.demo.model.*;

@Controller
public class PengumumanController {
	private PengumumanService pengumumanService;
	
	@Autowired
	public void setPengumumanService(PengumumanService pengumumanService) {
		this.pengumumanService = pengumumanService;
	}
	
	@RequestMapping("/pengumuman")
	public String PengumumanList(Model model) {
		model.addAttribute("pengumuman", pengumumanService.listPengumuman());
		return"pengumuman";
	}
	
	@RequestMapping(value = "/pengumuman/create", method = RequestMethod.GET)
	public String tampilkanForm (Model model) {
		model.addAttribute("pengumuman", new Pengumuman());
		return "formPengumuman";
	}
	
	@RequestMapping(value = "/pengumuman/create", method = RequestMethod.POST)
	public String simpanPengumuman(Model model, Pengumuman pengumuman) {
		model.addAttribute("pengumuman", pengumumanService.saveOrUpdate(pengumuman));
		return "redirect:/pengumuman";
	}
	
	/*@RequestMapping(value = "/mahasiswa/hapus/{Id}", method = RequestMethod.GET)
	public String hapusMahasiswa(@PathVariable Integer Id) {
		mahasiswaService.hapusMahasiswa(Id);
		return "redirect:/mahasiswa";
	}*/	
	
	@RequestMapping(value="/pengumuman/hapus/{id}", method = RequestMethod.GET)
	public String hapusPengumuman(@PathVariable Integer id) {
		pengumumanService.hapusPengumuman(id);
		return "redirect:/pengumuman";
	}
	
	/*@RequestMapping(value= "/mahasiswa/edit/{Id}", method = RequestMethod.GET)
	public String updateMahasiswa(@PathVariable Integer Id, Model model) {
		model.addAttribute("mahasiswa", mahasiswaService.getId(Id));
		return"formMahasiswa";
	}*/
	
	@RequestMapping(value="/pengumuman/edit/{id}", method = RequestMethod.GET)
	public String updatePengumuman(@PathVariable Integer id, Model model) {
		model.addAttribute("pengumuman", pengumumanService.getId(id));
		return "formPengumuman";
	}
	
	@RequestMapping(value="/pengumuman/detail/{id}", method = RequestMethod.GET)
	public String detailPengumuman(@PathVariable Integer id, Model model) {
		model.addAttribute("pengumuman", pengumumanService.getId(id));
		return "detailPengumuman";
	}
}
