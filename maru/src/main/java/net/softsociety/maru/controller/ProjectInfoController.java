package net.softsociety.maru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.service.project.ProjectInfoService;

@Slf4j
@Controller
@RequestMapping("/project")
public class ProjectInfoController {

	@Autowired
	ProjectInfoService projectInfoService; 
	
	
	@GetMapping("/projectInfo")
	public String projectInfo(Model model
			,@RequestParam(name="projects_num", defaultValue = "0") int projects_num) {
		List<Projects> projectsList = projectInfoService.selectAllProjects();
		log.debug("프로젝트 리스트:{}",projectsList);
		
		model.addAttribute("projectsList",projectsList);
		
		Projects projects = projectInfoService.selectOne(projects_num);
		log.debug("선택된 프로젝트 : {}",projects);
		
		model.addAttribute("projects",projects);
		
		return "project/projectInfo";
	}
	
	@GetMapping("/allProjectsInfo")
	public String allProjectsInfo(Model model) {
		List<Projects> projectsList = projectInfoService.selectAllProjects();
		log.debug("프로젝트 리스트:{}",projectsList);
		
		model.addAttribute("projectsList",projectsList);
		
		
		return "project/allProjectsInfo";
	}
}
