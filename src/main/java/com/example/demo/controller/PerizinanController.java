package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.services.PerizinanService;
import com.example.demo.model.*;

@Controller
public class PerizinanController {
	private PerizinanService perizinanService;
	
	@Autowired
	public void setPerizinanService(PerizinanService perizinanService) {
		this.perizinanService = perizinanService;
	}
	
	@RequestMapping("/perizinan")
	public String PerizinanList(Model model) {
		model.addAttribute("perizinan", perizinanService.listPerizinan());
		return"perizinan";
	}
	
	@RequestMapping(value = "/perizinan/create", method = RequestMethod.GET)
	public String tampilkanForm (Model model) {
		model.addAttribute("perizinan", new Perizinan());
		return "formPerizinan";
	}
	
	@RequestMapping(value = "/perizinan/create", method = RequestMethod.POST)
	public String simpanPerizinan(Model model, Perizinan perizinan) {
		model.addAttribute("perizinan", perizinanService.saveOrUpdate(perizinan));
		return "redirect:/perizinan";
	}
	
	/*@RequestMapping(value = "/mahasiswa/hapus/{Id}", method = RequestMethod.GET)
	public String hapusMahasiswa(@PathVariable Integer Id) {
		mahasiswaService.hapusMahasiswa(Id);
		return "redirect:/mahasiswa";
	}*/	
	
	@RequestMapping(value="/perizinan/hapus/{id}", method = RequestMethod.GET)
	public String hapusPerizinan(@PathVariable Integer id) {
		perizinanService.hapusPerizinan(id);
		return "redirect:/perizinan";
	}
	
	/*@RequestMapping(value= "/mahasiswa/edit/{Id}", method = RequestMethod.GET)
	public String updateMahasiswa(@PathVariable Integer Id, Model model) {
		model.addAttribute("mahasiswa", mahasiswaService.getId(Id));
		return"formMahasiswa";
	}*/
	
	@RequestMapping(value="/perizinan/edit/{id}", method = RequestMethod.GET)
	public String updatePerizinan(@PathVariable Integer id, Model model) {
		model.addAttribute("perizinan", perizinanService.getId(id));
		return "formPerizinan";
	}
	
	@RequestMapping(value="/perizinan/detail/{id}", method = RequestMethod.GET)
	public String detailPerizinan(@PathVariable Integer id, Model model) {
		model.addAttribute("perizinan", perizinanService.getId(id));
		return "detailPerizinan";
	}
}
