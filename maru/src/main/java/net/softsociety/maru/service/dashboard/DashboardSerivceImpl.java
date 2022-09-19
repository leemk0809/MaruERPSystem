package net.softsociety.maru.service.dashboard;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.dao.CommitWorkerDAO;
import net.softsociety.maru.dao.IssueDAO;
import net.softsociety.maru.dao.ProjectsDAO;
import net.softsociety.maru.domain.CommitWorker;
import net.softsociety.maru.domain.Issue;
import net.softsociety.maru.domain.Projects;

@Slf4j
@Service
public class DashboardSerivceImpl implements DashboardService {

	@Autowired
	ProjectsDAO pdao;

	@Autowired
	CommitWorkerDAO cdao;

	@Autowired
	IssueDAO idao;

	@Override
	public ArrayList<Projects> selectAllProjects() {
		ArrayList<Projects> projectsList = pdao.selectAll();
		return projectsList;
	}

	@Override
	public ArrayList<CommitWorker> selectAllCommitWorker() {
		ArrayList<CommitWorker> commitWorkerList = (ArrayList<CommitWorker>) cdao.selectAll();
		return commitWorkerList;
	}

	@Override
	public ArrayList<Issue> selectAllIssue() {
		ArrayList<Issue> issueList = (ArrayList<Issue>) idao.selectAll();
		
		ArrayList<Issue> returnissueList = new ArrayList<Issue>();
		
		returnissueList.add(issueList.get(0));
		returnissueList.add(issueList.get(1));
		returnissueList.add(issueList.get(2));
		returnissueList.add(issueList.get(3));
		
		return returnissueList;
	}

	@Override
	public int calcProgress(int projects_num) {
		Projects selectProjects = pdao.selectOne(projects_num);
		double progressTot = selectProjects.getNeed_worker();
		double progressCurrent = 0;

		Calendar calendar = new GregorianCalendar();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);

		Calendar currDate = new GregorianCalendar();
		currDate.set(year, month + 1, day);

		ArrayList<CommitWorker> commitWorkerList = (ArrayList<CommitWorker>) cdao.selectAll();

		for (CommitWorker cw : commitWorkerList) {

			if (cw.getProjects_num() == projects_num) {
				String endDateTemp = cw.getEnd_date().toString();

				int year2 = Integer.parseInt(endDateTemp.substring(0, 4));
				int month2 = Integer.parseInt(endDateTemp.substring(5, 7));
				int day2 = Integer.parseInt(endDateTemp.substring(8, 10));

				Calendar endDate = new GregorianCalendar();
				endDate.set(year2, month2 + 1, day2);

				if (currDate.before(endDate)) {
					progressCurrent += 1;
				}
			}
		}
		//log.debug("진행도 : " + (int) (progressCurrent / progressTot * 100) + "%");
		return (int) (progressCurrent / progressTot * 100);
	}

	@Override
	public int calcCommitDate(int projects_num) {

		Projects p = pdao.selectOne(projects_num);

		String startDateTemp = p.getStart_date();

		int yearS = Integer.parseInt(startDateTemp.substring(0, 4));
		int monthS = Integer.parseInt(startDateTemp.substring(5, 7));
		int dayS = Integer.parseInt(startDateTemp.substring(8, 10));
		Calendar startDate = new GregorianCalendar();
		startDate.set(yearS, monthS + 1, dayS);
		
		//log.debug(startDate + "시작일");

		String endDateTemp = p.getEnd_date();

		int yearE = Integer.parseInt(endDateTemp.substring(0, 4));
		int monthE = Integer.parseInt(endDateTemp.substring(5, 7));
		int dayE = Integer.parseInt(endDateTemp.substring(8, 10));
		Calendar endDate = new GregorianCalendar();	
		endDate.set(yearE, monthE + 1, dayE);
		
		//log.debug(endDate +"끝일");
		
		long diffSec = (endDate.getTimeInMillis() - startDate.getTimeInMillis()) / 1000;
		long diffDays = diffSec / (24 * 60 * 60);

		//log.debug((int) diffDays + "일");
		
		return (int) diffDays;
	}

	@Override
	public int countAllProjects() {
		ArrayList<Projects> projectsList = pdao.selectAll();
		return projectsList.size();
	}

	@Override
	public int countBeforePaymentProjects() {
		ArrayList<Projects> projectsList = pdao.selectAll();
		int count = 0;
		
		for(Projects p : projectsList) {
			if(p.getStatus().equals("진행전")) {
				count++;
			}
		}		
		return count;
	}

	@Override
	public int countPayingProjects() {
		ArrayList<Projects> projectsList = pdao.selectAll();
		int count = 0;
		
		for(Projects p : projectsList) {
			if(p.getStatus().equals("결재중")) {
				count++;
			}
		}		
		return count;
	}

	@Override
	public int countProceedingProjects() {
		ArrayList<Projects> projectsList = pdao.selectAll();
		int count = 0;
		
		for(Projects p : projectsList) {
			if(p.getStatus().equals("진행중")) {
				count++;
			}
		}		
		return count;
	}

	@Override
	public int countCompletionProjects() {
		ArrayList<Projects> projectsList = pdao.selectAll();
		int count = 0;
		
		for(Projects p : projectsList) {
			if(p.getStatus().equals("완료")) {
				count++;
			}
		}		
		return count;
	}

	@Override
	public ArrayList<Projects> currEndProject() {
		
		LocalDate now = LocalDate.now();

		String currMonth = "";
		
		currMonth += now.toString().substring(2, 4) + "/";
		currMonth += now.toString().substring(5, 7);

		//log.debug(currMonth+"");
		
		ArrayList<Projects> list = pdao.selectcurrEndProject(currMonth);
		
		return list;
	}

	@Override
	public String calcD_day(int projects_num) {
		Projects p = pdao.selectOne(projects_num);

		Calendar calendar = new GregorianCalendar();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DATE);

		Calendar currDate = new GregorianCalendar();
		currDate.set(year, month + 1, day);
		
		log.debug(currDate + "오늘");

		String endDateTemp = p.getEnd_date();

		int yearE = Integer.parseInt(endDateTemp.substring(0, 4));
		int monthE = Integer.parseInt(endDateTemp.substring(5, 7));
		int dayE = Integer.parseInt(endDateTemp.substring(8, 10));
		Calendar endDate = new GregorianCalendar();	
		endDate.set(yearE, monthE, dayE);
		
		log.debug(endDate +"끝일");
		
		long diffSec = (endDate.getTimeInMillis() - currDate.getTimeInMillis()) / 1000;
		long diffDays = diffSec / (24 * 60 * 60);
		
		String returnStr ="";
		
		if(diffDays < 0) {
			returnStr = "+" + diffDays*(-1);
		}else {
			returnStr = "-" + diffDays;
		}
		
		return returnStr;
	}

	@Override
	public int calcIssue(int projects_num) {
		ArrayList<Issue> issueList = (ArrayList<Issue>) idao.selectAll();
		
		int cnt = 0;	
		
		for(Issue i : issueList) {
			if(projects_num == i.getProjects_num()) {
				cnt++;
			}
		}
		return cnt;
	}
}
