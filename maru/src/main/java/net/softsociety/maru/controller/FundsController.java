package net.softsociety.maru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.service.manage.FundsService;

@Slf4j
@Controller
@RequestMapping("/manage")
public class FundsController {

	@Autowired
	FundsService service;
	
	@GetMapping("/funds")
	public String index(Model model) {
		//프로젝트별 수입
		int proSales1 = service.projectSales(1);
		int proSales2 = service.projectSales(2);
		int proSales3 = service.projectSales(3);
		int proSales4 = service.projectSales(4);
		
		model.addAttribute("proSales1",proSales1);
		model.addAttribute("proSales2",proSales2);
		model.addAttribute("proSales3",proSales3);
		model.addAttribute("proSales4",proSales4);
		
		
		
		return "manage/funds";
	}
}
