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
	
	//프로젝트 총갯수
	public int countAllProjects();
	
	//프로젝트 갯수(결재전 갯수)
	public int countBeforePaymentProjects();
	
	//프로젝트 갯수(결재중 갯수)
	public int countPayingProjects();
	
	//프로젝트 갯수(진행중 갯수)
	public int countProceedingProjects();
		
	//프로젝트 갯수(완료된 갯수)
	public int countCompletionProjects();
	
	//실제 프로젝트별 진행도 계산을 위한 함수
	public int calcProgress(int projects_num);
	
	//프로젝트별 투입 기간 계산을 위한 함수
	public int calcCommitDate(int projects_num); 
	
	//이슈
	public ArrayList<Issue> selectAllIssue();
	
	//이번단 종료되는 프로젝트
	public ArrayList<Projects> currEndProject();
}
