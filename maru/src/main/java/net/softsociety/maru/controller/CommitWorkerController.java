package net.softsociety.maru.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.dao.PositionDAO;
import net.softsociety.maru.domain.Calender;
import net.softsociety.maru.domain.CommitWorker;
import net.softsociety.maru.domain.Position;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.domain.Worker;
import net.softsociety.maru.domain.WorkerTot;
import net.softsociety.maru.service.manage.WorkerService;
import net.softsociety.maru.service.project.CommitWorkerService;
import net.softsociety.maru.service.project.ProjectInfoService;

@Controller
@Slf4j
public class CommitWorkerController {

	@Autowired
	ProjectInfoService pService;

	@Autowired
	CommitWorkerService cwService;

	@Autowired
	WorkerService wService;

	@Autowired
	PositionDAO podao;

	@GetMapping("project/commitWorker")
	public String commmitWorker(Model model,
			@RequestParam(name = "projects_num", defaultValue = "0") int projects_num) {
		
		model.addAttribute("projects", pService.selectOne(projects_num));

		// 옆의메뉴
		List<Projects> pList = pService.selectAllProjects();
		model.addAttribute("Plist", pList);

		// 테이블
		List<Worker> wList = wService.selectAllWorker(projects_num);
		List<Position> poList = podao.selectAll();
		List<CommitWorker> cwList = cwService.selectAllCommitWorker();

		List<WorkerTot> wtList = new ArrayList<WorkerTot>();

		for (CommitWorker cw : cwList) {
			if (cw.getProjects_num() == projects_num) {
				for (Worker w : wList) {
					if(cw.getWorker_num() == w.getWorker_num()) {
						for(Position po : poList) {
							if(cw.getCommit_worker_num()==po.getPosition_num()) {
								
								WorkerTot wt = new WorkerTot();
								wt.setWc(w);
								wt.setName(w.getName());
								wt.setPosition_name(po.getPosition_name());

								wtList.add(wt);
							}
						}//end poList loop
					}
				}//end wList loop
			}
		}//end cwList loop
		
		model.addAttribute("wtList", wtList);
		
		log.debug("wtList : " + wtList);

		return "project/commitWorker";
	}

	@GetMapping("calendar2")
	public String calender(int projects_num) {
		return "../static/calendar/calender2.html";
	}

	@ResponseBody
	@GetMapping("calendar/calendarEvents2")
	public ArrayList<Calender> calendarEvents(
			@RequestParam(name = "projects_num", defaultValue = "1") int projects_num) {

		// log.debug(projects_num + "프로젝트 넘버");

		ArrayList<CommitWorker> cwList = (ArrayList<CommitWorker>) cwService.selectAllCommitWorker();
		ArrayList<Worker> wList = (ArrayList<Worker>) wService.selectAll();
		ArrayList<Calender> cList = new ArrayList<Calender>();

		for (CommitWorker cw : cwList) {
			for (Worker w : wList) {
				if (cw.getProjects_num() == projects_num) {
					if (w.getWorker_num() == cw.getWorker_num()) {
						Calender c = new Calender(w.getName(), cw.getCommit_date().split(" ")[0],
								cw.getEnd_date().split(" ")[0]);
						cList.add(c);
					}
				}
			}
		}
		return cList;
	}

}
