package net.softsociety.maru.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.dao.MaterialDAO;
import net.softsociety.maru.dao.PositionDAO;
import net.softsociety.maru.dao.ProjectsTagDAO;
import net.softsociety.maru.domain.NeedMaterial;
import net.softsociety.maru.domain.Position;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.domain.ProjectsTag;
import net.softsociety.maru.domain.SignTot;
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

	@Autowired
	ProjectsTagDAO PTdao;

	@Autowired
	PositionDAO Podao;

	@GetMapping("signDetail")
	public String signDetail(Model model,int projects_num) { // int projects_num 매개변수로 받아오기
		

		
		Projects projects = PIservice.selectOne(projects_num); // projects_num

		String nmStr = "";

		ArrayList<NeedMaterial> needMatrialList = (ArrayList<NeedMaterial>) NMservice.thisNMList(projects_num); // projects_num

		if (needMatrialList != null) {
			for (NeedMaterial nm : needMatrialList) {
				nmStr += Mdao.selectOne(nm.getProjects_num()).getMaterial_name() + " : \n";
				nmStr += nm.getCount() + "개 \n";
			}
		}

		model.addAttribute("projects", projects);
		model.addAttribute("nmStr", nmStr);

		ArrayList<ProjectsTag> PTList = PTdao.selectAll();

		ArrayList<SignTot> STList = new ArrayList<>();

		ArrayList<Position> PoList = (ArrayList<Position>) Podao.selectAll();

		for (ProjectsTag PT : PTList) {
			if (PT.getProjects_num() == projects_num) { // projects_num
				SignTot st = new SignTot(PT.getProjects_tag_num(), PT.getPosition_num(),PT.getProjects_num() ,PT.getTag_sign());
				for (Position po : PoList) {
					if (po.getPosition_num() == (PT.getPosition_num())) {
						st.setPosition(po.getPosition_name());
					}
				}
				STList.add(st);
			}
		}
		
		

		model.addAttribute("STList", STList);

		return "dashboard/signDetail.html";
	}

	@ResponseBody
	@GetMapping("signed")
	public String signed(int projects_num) {

		int result = SDservice.stamp(projects_num);

		return "redirect:/dashboard/signDetail";
	}
}
