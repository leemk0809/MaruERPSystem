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
	public String sign(Model model) {
		
		ArrayList<Projects> pList = service.selectAllProjects();
		model.addAttribute("pList",pList);
		
		return "/dashboard/sign";
	}
		

}
