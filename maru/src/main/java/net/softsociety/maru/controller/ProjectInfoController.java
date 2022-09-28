package net.softsociety.maru.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.service.project.InsertProjectService;
import net.softsociety.maru.service.project.ProjectInfoService;

@Slf4j
@Controller
@RequestMapping("/project")
public class ProjectInfoController {

	@Autowired
	ProjectInfoService projectInfoService; 
	
	@Autowired
	InsertProjectService insertProjectService;
	
	
	@GetMapping("/projectInfo")
	public String projectInfo(Model model
			,@RequestParam(name="projects_num", defaultValue = "0") int projects_num) {
		List<Projects> pList = projectInfoService.selectAllProjects();
		log.debug("프로젝트 리스트:{}",pList);
		List<Projects> projectsList = new ArrayList<Projects>();
		
		for(Projects project: pList) {
			if(project.getStatus().equals("진행중")) {
				projectsList.add(project);
			}
		}
		model.addAttribute("projectsList",projectsList);
		
		Projects projects = projectInfoService.selectOne(projects_num);
		log.debug("선택된 프로젝트 : {}",projects);
		
		model.addAttribute("projects",projects);
		
		int buildingProgress = projectInfoService.buildingProgress(projects_num);
		int civilEngineeringProgress = projectInfoService.civilEngineeringProgress(projects_num);
		int electricityProgress = projectInfoService.electricityProgress(projects_num);
		int machineProgress = projectInfoService.machineProgress(projects_num);
		log.debug("건축팀:{}",buildingProgress);
		log.debug("토목팀:{}",civilEngineeringProgress);
		log.debug("전기팀:{}",electricityProgress);
		log.debug("기계팀:{}",machineProgress);
		
		model.addAttribute("build",buildingProgress);
		model.addAttribute("civil",civilEngineeringProgress);
		model.addAttribute("electricity",electricityProgress);
		model.addAttribute("machine",machineProgress);
		
		int projectProgress = projectInfoService.projectsProgress(projects_num);
		log.debug("프로젝트 진척도:{}",projectProgress);
		
		model.addAttribute("projectProgress",projectProgress);
		
		int materialProgress = projectProgress - Math.round((buildingProgress+civilEngineeringProgress + electricityProgress + machineProgress)/4);
		log.debug("자재 진척도:{}",materialProgress);
		
		model.addAttribute("materialProgress",materialProgress);
		
		return "project/projectInfo";
	}
	
	@GetMapping("/allProjectsInfo")
	public String allProjectsInfo(Model model) {
		List<Projects> projectsList = projectInfoService.selectAllProjects();
		List<Projects> selectedProjectList = new ArrayList<>();
		log.debug("프로젝트 리스트:{}",projectsList);
		
		model.addAttribute("projectsList",projectsList);
		
		for(Projects p : projectsList) {
			if(p.getStatus().equals("결재전")) {
				selectedProjectList.add(p);
			}
		}
		
		log.debug("selectedProjectList : {}", selectedProjectList);
		
		for(int i = 0 ; i < selectedProjectList.size(); i++) {
			int price = insertProjectService.calcPredictPrice(selectedProjectList.get(i).getPost_num());
			
			model.addAttribute("price" + i, price);
			model.addAttribute("selectedProject" + i, selectedProjectList.get(i));
		}
		
		
		List<Projects> ingList = new ArrayList<Projects>();
		
		for(Projects project: projectsList) {
			if(project.getStatus().equals("진행중")) {
				ingList.add(project);
			}
		}
		model.addAttribute("ingList",ingList);
		
		return "project/allProjectsInfo";
	}
}
