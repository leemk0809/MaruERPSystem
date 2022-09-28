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
		int proSales1 = service.projectSales(1);	//1번프로젝트 수입
		int proSales2 = service.projectSales(24);	//2번프로젝트 수입
		int proSales3 = service.projectSales(25);
		int proSales4 = service.projectSales(26);		
		model.addAttribute("proSales1",proSales1);
		model.addAttribute("proSales2",proSales2);
		model.addAttribute("proSales3",proSales3);
		model.addAttribute("proSales4",proSales4);
		
		
		//분기별 수입/지출 지표		
		ArrayList<Integer> qsList22= service.quarterlySales(2022);	//2022년 수입
		int qs221=qsList22.get(0);		//1분기 수입
		int qs222=qsList22.get(1);		//2분기 수입
		int qs223=qsList22.get(2);
		int qs224=qsList22.get(3);
		model.addAttribute("qs221",qs221);
		model.addAttribute("qs222",qs222);
		model.addAttribute("qs223",qs223);
		model.addAttribute("qs224",qs224);
		ArrayList<Integer> qeList22 = service.quarterlyExpense(2022);	//2022년 지출
		model.addAttribute("qeList22",qeList22);	
		int qe221=qeList22.get(0);					//1분기 지출
		int qe222=qeList22.get(1);					//2분기 지출
		int qe223=qeList22.get(2);					//3분기 지출
		int qe224=qeList22.get(3);
		model.addAttribute("qe221",qe221);
		model.addAttribute("qe222",qe222);
		model.addAttribute("qe223",qe223);
		model.addAttribute("qe224",qe224);
		
		
		
		//프로젝트 내 지출 비율 
		ArrayList<Integer> rateList= service.projectExpenseRate(1);		//1번 프로젝트 내 지출 비율
		//model.addAttribute("rateList",rateList);
		
		int exRate1 = rateList.get(0);		//식비(사실 비율 아니고 데이터지만 그럴수있다 생각함.)
		int exRate2 = rateList.get(1);		//인건비
		int exRate3 = rateList.get(2);		//자재비
		int exRate4 = rateList.get(3);		//기타비
		
		model.addAttribute("exRate1",exRate1);
		model.addAttribute("exRate2",exRate2);
		model.addAttribute("exRate3",exRate3);
		model.addAttribute("exRate4",exRate4);		
		
		return "manage/funds";
	}
	

}
