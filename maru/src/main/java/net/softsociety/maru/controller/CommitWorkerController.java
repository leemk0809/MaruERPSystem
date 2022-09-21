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

@Controller
@Slf4j
@RequestMapping("/project")
public class CommitWorkerController {
	
	@Autowired
	ProjectInfoService pService;
	
	@GetMapping("commitWorker")
	public String commmitWorker(Model model
			,@RequestParam(name="projects_num", defaultValue = "0") int projects_num) {
		List<Projects> list = pService.selectAllProjects();
		model.addAttribute("projectsList", list);
		
		model.addAttribute("projects", pService.selectOne(projects_num));
		
		return "project/commitWorker";
	}
	
}
