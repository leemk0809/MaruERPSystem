package net.softsociety.maru.service.project;

import java.util.ArrayList;

import net.softsociety.maru.domain.Projects;

public interface ProjectInfoService {

	//프로젝트 전체 리스트 불러오는 서비스
	ArrayList<Projects> selectAllProjects();
	//프로젝트의 기본 정보를확인하기위해 해당 프로젝트 내용을 불러오는 서비스
	//설계도와 조감도도 불러와서 화면에 표시할것
	Projects selectOne(int projects_num);	
	//건축, 토목, 전기, 기계 각 팀별 진행도 
	int buildingProgress(int projects_num);
	int civilEngineeringProgress(int projects_num);
	int electricityProgress(int projects_num);
	int machineProgress(int projects_num);
	
	//전체 진행도 투입인력 + 투입자재 계산하여 확인
	int projectsProgress(int projects_num);
	
}
