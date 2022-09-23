package net.softsociety.maru.controller;

import java.util.ArrayList;

import javax.sound.sampled.Port;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.dao.MaterialDAO;
import net.softsociety.maru.domain.NeedMaterial;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.service.dashboard.SignDetailService;
import net.softsociety.maru.service.manage.NeedMaterialService;
import net.softsociety.maru.service.project.ProjectInfoService;

@RequestMapping("dashboard")
@Slf4j
@Controller
public class SignDetailController {

	@Autowired
	ProjectInfoService PIservice;

	@Autowired
	SignDetailService SDservice;

	@Autowired
	NeedMaterialService NMservice;

	@Autowired
	MaterialDAO Mdao;

	@GetMapping("signDetail")
	public String signDetail(Model model) {

		Projects projects = PIservice.selectOne(1);

		String nmStr = "";
		ArrayList<NeedMaterial> needMatrialList = (ArrayList<NeedMaterial>) NMservice.thisNMList(1);
		if (needMatrialList != null) {
			for (NeedMaterial nm : needMatrialList) {
				nmStr += Mdao.selectOne(nm.getProjects_num()).getMaterial_name() + " : \n";
				nmStr += nm.getCount() + "개 \n";
			}
		}
		model.addAttribute("projects", projects);
		model.addAttribute("nmStr", nmStr);
		
		return "dashboard/signDetail.html";
	}
	
	@ResponseBody
	@GetMapping("signed")
	public String signed(int projects_num) {
		
		log.debug(projects_num+"이거임");
		
		return "응가";
	}
}
