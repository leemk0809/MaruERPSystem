package net.softsociety.maru.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Issue;
import net.softsociety.maru.service.dashboard.DashboardService;

@Slf4j
@Controller
public class DashboardController {

	@Autowired
	DashboardService dashboardService;
	
	@GetMapping({"calendar"})
	public String calender() {
		
		
		
		return "../static/calendar/calender.html";
	}

	@GetMapping({ "", "/", "dashboard" })
	public String index(Model model) {
		
		int totProject = dashboardService.countAllProjects();
		
		model.addAttribute("totProject", totProject + "건");
		
		String projectStr = "";
		
		int countBeforePaymentProjects = dashboardService.countBeforePaymentProjects();
		int countPayingProjects = dashboardService.countPayingProjects();
		int countProceedingProjects = dashboardService.countProceedingProjects();
		int countCompletionProjects =  dashboardService.countCompletionProjects();
		
		projectStr += "진행전  :  " + countBeforePaymentProjects + "  결재중  :  " + countPayingProjects
				+ "  진행중  :  " + countProceedingProjects + "  완료된  :  " + countCompletionProjects;
		
		model.addAttribute("projectStr",projectStr);
		
		ArrayList<Issue> issueList = dashboardService.selectAllIssue();
		
		log.debug(issueList + "컨트롤러");
		
		model.addAttribute("issueList", issueList);
		
		return "dashboard/dashboard.html";
	}
	
}
