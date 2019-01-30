package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.services.AsramaService;
import com.example.demo.services.PiketService;
import com.example.demo.model.*;

@Controller
public class PiketController {
	private PiketService piketService;
	private AsramaService asramaService;
	
	@Autowired
	public void setPiketService(PiketService piketService, AsramaService asramaService) {
		this.piketService = piketService;
		this.asramaService = asramaService;
	}
	
	@RequestMapping("/piket")
	public String PiketList(Model model) {
		model.addAttribute("piket", piketService.listPiket());
		return"piket";
	}
	
	@RequestMapping(value = "/piket/create", method = RequestMethod.GET)
	public String tampilkanForm (Model model) {
		model.addAttribute("piket", new Piket());
		model.addAttribute("asrama", asramaService.listAsrama());
		return "formPiket";
	}
	
	@RequestMapping(value = "/piket/create", method = RequestMethod.POST)
	public String simpanPiket(Model model, Piket piket) {
		model.addAttribute("piket", piketService.saveOrUpdate(piket));
		return "redirect:/piket";
	}
	
	/*@RequestMapping(value = "/mahasiswa/hapus/{Id}", method = RequestMethod.GET)
	public String hapusMahasiswa(@PathVariable Integer Id) {
		mahasiswaService.hapusMahasiswa(Id);
		return "redirect:/mahasiswa";
	}*/	
	
	@RequestMapping(value="/piket/hapus/{id}", method = RequestMethod.GET)
	public String hapusPiket(@PathVariable Integer id) {
		piketService.hapusPiket(id);
		return "redirect:/piket";
	}
	
	/*@RequestMapping(value= "/mahasiswa/edit/{Id}", method = RequestMethod.GET)
	public String updateMahasiswa(@PathVariable Integer Id, Model model) {
		model.addAttribute("mahasiswa", mahasiswaService.getId(Id));
		return"formMahasiswa";
	}*/
	
	@RequestMapping(value="/piket/edit/{id}", method = RequestMethod.GET)
	public String updatePiket(@PathVariable Integer id, Model model) {
		model.addAttribute("piket", piketService.getId(id));
		return "formPiket";
	}
	
	@RequestMapping(value="/piket/detail/{id}", method = RequestMethod.GET)
	public String detailPiket(@PathVariable Integer id, Model model) {
		model.addAttribute("piket", piketService.getId(id));
		return "detailPiket";
	}
}
