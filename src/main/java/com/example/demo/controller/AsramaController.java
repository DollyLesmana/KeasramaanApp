package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.AsramaService;
import com.example.demo.services.PiketService;

@Controller
public class AsramaController {
	
	private PiketService piketService;
	private AsramaService asramaService;
	
	@Autowired
	public void injectDependency(PiketService piketService, AsramaService asramaService) {
		this.piketService = piketService;
		this.asramaService = asramaService;
	}
	
	@RequestMapping("/asrama")
	public String asrama() {
		return"asrama";
	}
	
	@RequestMapping("/antiokhia")
	public String Antiokhia(Model model) {
		model.addAttribute("piket", piketService.listPiket(1));
		model.addAttribute("asramaService", asramaService);
		return"asrama/antiokhia";
	}
	
	@RequestMapping("/betfage")
	public String Betfage(Model model) {
		model.addAttribute("piket", piketService.listPiket(2));
		model.addAttribute("asramaService", asramaService);
		return"asrama/betfage";
	}
	
	@RequestMapping("/kapernaum")
	public String Kapernaum(Model model) {
		model.addAttribute("piket", piketService.listPiket(3));
		model.addAttribute("asramaService", asramaService);
		return"asrama/kapernaum";
	}
	
	@RequestMapping("/mahanaim")
	public String Mahanaim(Model model) {
		model.addAttribute("piket", piketService.listPiket(4));
		model.addAttribute("asramaService", asramaService);
		return"asrama/mahanaim";
	}
	
	@RequestMapping("/mamre")
	public String Mamre(Model model) {
		model.addAttribute("piket", piketService.listPiket(5));
		model.addAttribute("asramaService", asramaService);
		return"asrama/mamre";
	}
	
	@RequestMapping("/nazareth")
	public String Nazareth(Model model) {
		model.addAttribute("piket", piketService.listPiket(6));
		model.addAttribute("asramaService", asramaService);
		return"asrama/nazareth";
	}
	
	@RequestMapping("/silo")
	public String Silo(Model model) {
		model.addAttribute("piket", piketService.listPiket(7));
		model.addAttribute("asramaService", asramaService);
		return"asrama/silo";
	}
	
	@RequestMapping("/pniel")
	public String Pniel(Model model) {
		model.addAttribute("piket", piketService.listPiket(8));
		model.addAttribute("asramaService", asramaService);
		return"asrama/pniel";
	}
}