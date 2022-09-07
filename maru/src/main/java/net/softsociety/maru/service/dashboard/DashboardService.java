package net.softsociety.maru.service.dashboard;

import java.util.ArrayList;

import net.softsociety.maru.domain.CommitWorker;
import net.softsociety.maru.domain.Issue;
import net.softsociety.maru.domain.Projects;

public interface DashboardService {

	//프로젝트 (진행%표시필요)
	public ArrayList<Projects> selectAllProjects();
	
	//진행률 계산을 위한 커밋워커 전체
	public ArrayList<CommitWorker> selectAllCommitWorker();
	
	//실제 프로젝트별 진행도 계산을 위한 함수
	public int calcProgress(int projects_num);
	
	//이슈
	public ArrayList<Issue> selectAllIssue();
}
