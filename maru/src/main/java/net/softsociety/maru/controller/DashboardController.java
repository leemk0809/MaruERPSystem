package net.softsociety.maru.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Calender;
import net.softsociety.maru.domain.Issue;
import net.softsociety.maru.domain.IssueTot;
import net.softsociety.maru.domain.Position;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.domain.ProjectsTot;
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

	@ResponseBody
	@GetMapping({ "calendar/calendarEvents" })
	public ArrayList<Calender> calendarEvents() {
		ArrayList<Projects> plist = dashboardService.selectAllProjects();
		ArrayList<Calender> clist = new ArrayList<Calender>();

		for (Projects p : plist) {

			Calender c = new Calender(p.getTitle(), p.getStart_date().substring(0, 10),
					p.getEnd_date().substring(0, 10));

			clist.add(c);
		}

		return clist;
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

		projectStr += "결재전  :  " + countBeforePaymentProjects + "  결재중  :  " + countPayingProjects + "  진행중  :  "
				+ countProceedingProjects + "  완료  :  " + countCompletionProjects;

		model.addAttribute("projectStr", projectStr);

		// 이번달 종료되는 프로젝트

		ArrayList<Projects> currEndProjects = dashboardService.currEndProject();

		ArrayList<ProjectsTot> returnCurrEndProjects = new ArrayList<ProjectsTot>();

		for (Projects p : currEndProjects) {

			int p_num = p.getProjects_num();
			String title = p.getTitle();
			String d_day = dashboardService.calcD_day(p.getProjects_num());
			int pr = dashboardService.calcProgress(p.getProjects_num());
			String state = p.getStatus();
			int issueCnt = dashboardService.calcCommitDate(p.getProjects_num());

			ProjectsTot cepj = new ProjectsTot(p_num, title, d_day, pr, state, issueCnt);
			returnCurrEndProjects.add(cepj);
		}

		model.addAttribute("returnCurrEndProjects", returnCurrEndProjects);

		// 이슈리스트
		ArrayList<Issue> issueList = dashboardService.selectAllIssue();

		for (Issue issue : issueList) {
			issue.setInput_date(issue.getInput_date().split(" ")[0]);
		}
		// log.debug(issueList + "컨트롤러");

		model.addAttribute("issueList", issueList);

		// 진행상황
		ArrayList<Projects> plist = dashboardService.selectAllProjects();

		ArrayList<ProjectsTot> totList = new ArrayList<ProjectsTot>();

		for (Projects p : plist) {

			int p_num = p.getProjects_num();
			String title = p.getTitle();
			String d_day = dashboardService.calcD_day(p.getProjects_num());
			int pr = dashboardService.calcProgress(p.getProjects_num());
			String state = p.getStatus();
			int issueCnt = dashboardService.calcIssue(p.getProjects_num());

			ProjectsTot totp = new ProjectsTot(p_num, title, d_day, pr, state, issueCnt);
			totList.add(totp);
		}

		model.addAttribute("totList", totList);

		// 이슈현황

		ArrayList<IssueTot> issueTotList = new ArrayList<IssueTot>();
		ArrayList<Position> positionList = dashboardService.selectAllPosition();

		for (Issue i : issueList) {

			int p_num = i.getProjects_num();
			String issueTitle = i.getTitle();
			String p_title = "";
			String positionName = "";
			for (Projects p : plist) {
				if (p_num == p.getProjects_num()) {
					p_title = p.getTitle();
				}
			}
			for (Position po : positionList) {
				if (i.getPosition_num() == po.getPosition_num()) {
					positionName = po.getPosition_name();
				}
			}

			IssueTot iTobj = new IssueTot(p_num, issueTitle, p_title, positionName, i.getInput_date().split(" ")[0]);

			issueTotList.add(iTobj);

		}

		model.addAttribute("issueTotList", issueTotList);
		
		return "dashboard/dashboard.html";
	}

}
