package net.softsociety.maru.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.domain.ProjectsTag;
import net.softsociety.maru.service.dashboard.SignService;

@Slf4j
@Controller
@RequestMapping("/dashboard")
public class SignController {
	
	@Autowired
	SignService service;
	
	@GetMapping("/sign")
	public String sign(Model model, int projects_num) {
		
		ArrayList<Projects> pList = service.selectAllProjects();
		log.debug("프로젝트 리스트:{}",pList);		
		model.addAttribute("pList",pList);
		
		
		
		String state = service.selectTag(projects_num);		
						
		log.debug("결재상황 : {}",state);
		model.addAttribute("state",state);
		
		return "/dashboard/sign";
	}
	

}
