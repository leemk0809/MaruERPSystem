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
import net.softsociety.maru.domain.CommitMaterial;
import net.softsociety.maru.domain.NeedMaterial;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.service.project.CommitMaterialService;
import net.softsociety.maru.service.project.ProjectInfoService;

@Slf4j
@Controller
@RequestMapping("/project")
public class CommitMaterialController {

	@Autowired
	ProjectInfoService projectInfoService;

	@Autowired
	CommitMaterialService commitMaterialService;

	@GetMapping("/commitMaterial")
	public String commitMaterial(Model model,
			@RequestParam(name = "projects_num", defaultValue = "0") int projects_num) {
		List<Projects> pList = projectInfoService.selectAllProjects();
		log.debug("프로젝트 리스트:{}", pList);
		List<Projects> projectsList = new ArrayList<Projects>();

		for (Projects project : pList) {
			if (project.getStatus().equals("진행중")) {
				projectsList.add(project);
			}
		}

		model.addAttribute("projectsList", projectsList);

		Projects projects = projectInfoService.selectOne(projects_num);
		log.debug("선택된 프로젝트 : {}", projects);

		model.addAttribute("projects", projects);

		List<CommitMaterial> thisProjectsCommitMaterialList = commitMaterialService
				.thisCommitMaterialList(projects_num);
		log.debug("해당 프로젝트 투입자재 리스트:{}", thisProjectsCommitMaterialList);

		model.addAttribute("CMList", thisProjectsCommitMaterialList);

		List<NeedMaterial> thisProjectsNeedMaterialList = commitMaterialService.thisNeedMaterialList(projects_num);
		log.debug("해당 프로젝트 필요자재 리스트:{}", thisProjectsNeedMaterialList);

		model.addAttribute("NMList", thisProjectsNeedMaterialList);

		return "/project/commitMaterial";
	}

	@GetMapping("allCommitMaterials")
	public String allCommitMaterials(Model model,
			@RequestParam(name = "projects_num", defaultValue = "0") int projects_num) {

		List<Projects> pList = projectInfoService.selectAllProjects();
		log.debug("프로젝트 리스트:{}", pList);
		List<Projects> projectsList = new ArrayList<Projects>();

		for (Projects project : pList) {
			if (project.getStatus().equals("진행중")) {
				projectsList.add(project);
			}
		}
		model.addAttribute("projectsList", projectsList);

		Projects projects = projectInfoService.selectOne(projects_num);
		log.debug("선택된 프로젝트 : {}", projects);

		model.addAttribute("projects", projects);

		List<CommitMaterial> allCMList = commitMaterialService.selectAllCommitMaterial();
		log.debug("전체 리스트:{}", allCMList);

		model.addAttribute("cmlist", allCMList);

		return "/project/allCommitMaterials";
	}

	@GetMapping("cmlist")
	public String cmlist(Model model, @RequestParam(name = "projects_num", defaultValue = "0") int projects_num) {

		return "/project/cmlist";
	}

	@GetMapping("cwlist")
	public String cwlist(Model model, @RequestParam(name = "projects_num", defaultValue = "0") int projects_num) {
		
		return "/project/cwlist";
	}
}
