package net.softsociety.maru.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.service.project.ProjectInfoService;

@Slf4j
@Controller
public class SignDetailController {

	@Autowired
	ProjectInfoService service;

	@GetMapping("dashboard/signDetail")
	public String signDetail(Model model, int projects_num) {

		Projects projects = service.selectOne(projects_num);

		// ArrayList<NeedMaterial>

		model.addAttribute("projects", projects);

		return "dashboard/signDetail.html";
	}

}
