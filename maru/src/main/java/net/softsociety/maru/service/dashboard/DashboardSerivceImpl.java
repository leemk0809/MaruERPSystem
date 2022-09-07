package net.softsociety.maru.service.dashboard;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.maru.dao.CommitWorkerDAO;
import net.softsociety.maru.dao.IssueDAO;
import net.softsociety.maru.dao.ProjectsDAO;
import net.softsociety.maru.domain.CommitWorker;
import net.softsociety.maru.domain.Issue;
import net.softsociety.maru.domain.Projects;

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
		
		ArrayList<CommitWorker> commitWorkerList = (ArrayList<CommitWorker>)cdao.selectAll();
		
		return commitWorkerList;
	}

	@Override
	public ArrayList<Issue> selectAllIssue() {
		
		ArrayList<Issue> issueList = (ArrayList<Issue>) idao.selectAll();
		
		return issueList;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int calcProgress(int projects_num) {
		Projects selectProjects = pdao.selectOne(projects_num);
		double progressTot = selectProjects.getNeed_worker();
		
		double progressCurrent = 0;
		
		String currDateTemp = LocalDate.now().toString();
		Date currDate = new Date(Integer.parseInt(currDateTemp.substring(0, 3)),Integer.parseInt(currDateTemp.substring(4, 5)),Integer.parseInt(currDateTemp.substring(6, 7)));

		
		ArrayList<CommitWorker> commitWorkerList = (ArrayList<CommitWorker>)cdao.selectAll();
		
		for(CommitWorker cw : commitWorkerList) {
			if(cw.getProjects_num()== projects_num) {
				
				String endDateTemp = cw.getEnd_date().toString();
				Date endDate = new Date(Integer.parseInt(endDateTemp.substring(0, 3)),Integer.parseInt(endDateTemp.substring(4, 5)),Integer.parseInt(endDateTemp.substring(6, 7)));
				
				if(endDate.before(currDate)) {
					progressCurrent += 1;
				}
			}
		}

		return (int)(progressCurrent/progressTot * 100);
	}
}
