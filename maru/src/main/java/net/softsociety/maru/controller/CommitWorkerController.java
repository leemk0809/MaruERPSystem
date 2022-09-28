package net.softsociety.maru.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Calender;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.service.project.ProjectInfoService;

@Controller
@Slf4j
public class CommitWorkerController {
	
	@Autowired
	ProjectInfoService pService;
	
	@GetMapping("project/commitWorker")
	public String commmitWorker(Model model
			,@RequestParam(name="projects_num", defaultValue = "0") int projects_num) {
		//List<Projects> list = pService.selectAllProjects();
		List<Projects> Plist = pService.selectAllProjects();
		
		//model.addAttribute("projectsList", list);
		
		model.addAttribute("projects", pService.selectOne(projects_num));
		
		model.addAttribute("Plist", Plist);
		
		return "project/commitWorker";
	}
	
	@GetMapping("calendar2")
	public String calender() {
		return "../static/calendar/calender2.html";
	}
	
	@ResponseBody
	@GetMapping({ "calendar/calendarEvents2" })
	public ArrayList<Calender> calendarEvents() {
//		ArrayList<Projects> plist = dashboardService.selectAllProjects();
//		ArrayList<Calender> clist = new ArrayList<Calender>();
//
//		for (Projects p : plist) {
//
//			Calender c = new Calender(p.getTitle(), p.getStart_date().substring(0, 10),
//					p.getEnd_date().substring(0, 10));
//
//			clist.add(c);
//		}

		return null;
	}
	
}
