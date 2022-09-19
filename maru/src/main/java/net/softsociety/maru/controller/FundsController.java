package net.softsociety.maru.controller;

import java.util.ArrayList;

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
		
		
		//분기별 수입/지출 지표		
		ArrayList<Integer> qsList22= service.quarterlySales(2022);
		int qs221=qsList22.get(0);
		int qs222=qsList22.get(1);
		int qs223=qsList22.get(2);
		int qs224=qsList22.get(3);
		model.addAttribute("qs221",qs221);
		model.addAttribute("qs222",qs222);
		model.addAttribute("qs223",qs223);
		model.addAttribute("qs224",qs224);
		ArrayList<Integer> qeList22 = service.quarterlyExpense(2022);
		model.addAttribute("qeList22",qeList22);
		int qe221=qeList22.get(0);		
		int qe222=qeList22.get(1);
		int qe223=qeList22.get(2);
		int qe224=qeList22.get(3);
		model.addAttribute("qe221",qe221);
		model.addAttribute("qe222",qe222);
		model.addAttribute("qe223",qe223);
		model.addAttribute("qe224",qe224);
		
		return "manage/funds";
	}

	private void alert(ArrayList<Integer> qeList22) {
		// TODO Auto-generated method stub
		
	}
}
