package net.softsociety.maru.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.ProjectsTot;
import net.softsociety.maru.domain.Issue;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.service.dashboard.DashboardService;

@Slf4j
@Controller
public class DashboardController {

	@Autowired
	DashboardService dashboardService;

	@GetMapping({ "calendar" })
	public String calender() {

		return "../static/calendar/calender.html";
	}

	@GetMapping({ "", "/", "dashboard" })
	public String index(Model model) {
		// 프로젝트 상황
		int totProject = dashboardService.countAllProjects();

		model.addAttribute("totProject", totProject + "건");

		String projectStr = "";

		int countBeforePaymentProjects = dashboardService.countBeforePaymentProjects();
		int countPayingProjects = dashboardService.countPayingProjects();
		int countProceedingProjects = dashboardService.countProceedingProjects();
		int countCompletionProjects = dashboardService.countCompletionProjects();

		projectStr += "진행전  :  " + countBeforePaymentProjects + "  결재중  :  " + countPayingProjects + "  진행중  :  "
				+ countProceedingProjects + "  완료  :  " + countCompletionProjects;

		model.addAttribute("projectStr", projectStr);

		// 이번달 종료되는 프로젝트

		ArrayList<Projects> currEndProjects = dashboardService.currEndProject();

		ArrayList<ProjectsTot> returnCurrEndProjects = new ArrayList<ProjectsTot>();

		for (Projects p : currEndProjects) {

			String title = p.getTitle();
			String d_day = dashboardService.calcD_day(p.getProjects_num());
			int pr = dashboardService.calcProgress(p.getProjects_num());
			String state = p.getStatus();
			int issueCnt = dashboardService.calcCommitDate(p.getProjects_num());

			ProjectsTot cepj = new ProjectsTot(title, d_day, pr, state, issueCnt);
			returnCurrEndProjects.add(cepj);
		}

		model.addAttribute("returnCurrEndProjects", returnCurrEndProjects);

		// 이슈리스트
		ArrayList<Issue> issueList = dashboardService.selectAllIssue();

		// log.debug(issueList + "컨트롤러");

		model.addAttribute("issueList", issueList);

		// 진행상황
		ArrayList<Projects> plist = dashboardService.selectAllProjects();
		
		ArrayList<ProjectsTot> totList = new ArrayList<ProjectsTot>();
		
		for(Projects p : plist) {
			String title = p.getTitle();
			String d_day = dashboardService.calcD_day(p.getProjects_num());
			int pr = dashboardService.calcProgress(p.getProjects_num());
			String state = p.getStatus();
			int issueCnt = dashboardService.calcIssue(p.getProjects_num());

			ProjectsTot totp = new ProjectsTot(title, d_day, pr, state, issueCnt);
			totList.add(totp);
		}
		
		model.addAttribute("totList", totList);
		
		// 이슈현황
		
		

		return "dashboard/dashboard.html";
	}

}
