package net.softsociety.maru.service.project;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.dao.CommitMaterialDAO;
import net.softsociety.maru.dao.CommitWorkerDAO;
import net.softsociety.maru.dao.ProjectsDAO;
import net.softsociety.maru.dao.WorkerDAO;
import net.softsociety.maru.domain.CommitMaterial;
import net.softsociety.maru.domain.CommitWorker;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.domain.Worker;

@Service
@Transactional
@Slf4j
public class ProjectInfoServiceImpl implements ProjectInfoService {

	@Autowired
	ProjectsDAO projectsDAO;

	@Autowired
	CommitWorkerDAO commitWorkerDAO;

	@Autowired
	CommitMaterialDAO commitMaterialDAO;

	@Autowired
	WorkerDAO workerDAO;

	@Override
	public ArrayList<Projects> selectAllProjects() {

		ArrayList<Projects> projectsList = projectsDAO.selectAll();

		return projectsList;
	}

	@Override
	public Projects selectOne(int projects_num) {

		Projects projects = projectsDAO.selectOne(projects_num);

		return projects;
	}

	@Override
	public int buildingProgress(int projects_num) {

		List<CommitWorker> commitWorkerList = commitWorkerDAO.selectAll();
		ArrayList<CommitWorker> thisList = new ArrayList<CommitWorker>();
		ArrayList<CommitWorker> thisBuildingList = new ArrayList<CommitWorker>();
		// commitWorker중에 이 프로젝트에 참여한 commitWorker 찾아서 thisList에 저장
		for (CommitWorker cw : commitWorkerList) {
			if (cw.getProjects_num() == projects_num) {
				thisList.add(cw);
			}
		}
		// 이 프로젝트에 참여한 인원의 워커넘으로 부서조회 후 건축팀이면 새로운 리스트에 저장
		for (CommitWorker cw : thisList) {
			Worker worker = workerDAO.selectOneWorker(cw.getWorker_num());
			if (worker.getDivision_num() == 1) {
				thisBuildingList.add(cw);
			}
		}
		// 현재 날짜 생성후 commitWorker의 end_date와 비교
		int cnt = 0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		String date = format.format(currentTime);

		for (CommitWorker cw : thisBuildingList) {
			int result = date.compareTo(cw.getEnd_date());
			if (result > 0) {
				cnt++;
			}
		}

		// 이 프로젝트 건축팀 중에 투입날짜 끝난 인원의 비율
		if (thisBuildingList.size() == 0) {
			int buildingProgress = 0;
			return buildingProgress;
		} else {
			int buildingProgress = Math.round((cnt / thisBuildingList.size()) * 100);
			return buildingProgress;
		}

	}

	@Override
	public int civilEngineeringProgress(int projects_num) {

		List<CommitWorker> commitWorkerList = commitWorkerDAO.selectAll();
		ArrayList<CommitWorker> thisList = new ArrayList<CommitWorker>();
		ArrayList<CommitWorker> thisCivilList = new ArrayList<CommitWorker>();
		// commitWorker중에 이 프로젝트에 참여한 commitWorker 찾아서 thisList에 저장
		for (CommitWorker cw : commitWorkerList) {
			if (cw.getProjects_num() == projects_num) {
				thisList.add(cw);
			}
		}
		// 이 프로젝트에 참여한 인원의 워커넘으로 부서조회 후 토목팀이면 새로운 리스트에 저장
		for (CommitWorker cw : thisList) {
			Worker worker = workerDAO.selectOneWorker(cw.getWorker_num());
			if (worker.getDivision_num() == 2) {
				thisCivilList.add(cw);
			}
		}
		// 현재 날짜 생성후 commitWorker의 end_date와 비교
		int cnt = 0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		String date = format.format(currentTime);

		for (CommitWorker cw : thisCivilList) {
			int result = date.compareTo(cw.getEnd_date());
			if (result > 0) {
				cnt++;
			}
		}
		// 이 프로젝트 토목팀 중에 투입날짜 끝난 인원의 비율

		if (thisCivilList.size() == 0) {

			int civilEngineeringProgress = 0;
			return civilEngineeringProgress;
		} else {
			int civilEngineeringProgress = Math.round((cnt / thisCivilList.size()) * 100);

			return civilEngineeringProgress;
		}
	}

	@Override
	public int electricityProgress(int projects_num) {

		List<CommitWorker> commitWorkerList = commitWorkerDAO.selectAll();
		ArrayList<CommitWorker> thisList = new ArrayList<CommitWorker>();
		ArrayList<CommitWorker> thisElectricityList = new ArrayList<CommitWorker>();
		// commitWorker중에 이 프로젝트에 참여한 commitWorker 찾아서 thisList에 저장
		for (CommitWorker cw : commitWorkerList) {
			if (cw.getProjects_num() == projects_num) {
				thisList.add(cw);
			}
		}
		// 이 프로젝트에 참여한 인원의 워커넘으로 부서조회 후 전기팀이면 새로운 리스트에 저장
		for (CommitWorker cw : thisList) {
			Worker worker = workerDAO.selectOneWorker(cw.getWorker_num());
			if (worker.getDivision_num() == 3) {
				thisElectricityList.add(cw);
			}
		}
		// 현재 날짜 생성후 commitWorker의 end_date와 비교
		int cnt = 0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		String date = format.format(currentTime);

		for (CommitWorker cw : thisElectricityList) {
			int result = date.compareTo(cw.getEnd_date());
			if (result > 0) {
				cnt++;
			}
		}
		// 이 프로젝트 전기팀 중에 투입날짜 끝난 인원의 비율
		if (thisElectricityList.size() == 0) {
			int electricityProgress = 0;
			return electricityProgress;
		} else {
			int electricityProgress = Math.round((cnt / thisElectricityList.size()) * 100);
			return electricityProgress;
		}
	}

	@Override
	public int machineProgress(int projects_num) {

		List<CommitWorker> commitWorkerList = commitWorkerDAO.selectAll();
		ArrayList<CommitWorker> thisList = new ArrayList<CommitWorker>();
		ArrayList<CommitWorker> thisMachineList = new ArrayList<CommitWorker>();
		// commitWorker중에 이 프로젝트에 참여한 commitWorker 찾아서 thisList에 저장
		for (CommitWorker cw : commitWorkerList) {
			if (cw.getProjects_num() == projects_num) {
				thisList.add(cw);
			}
		}
		// 이 프로젝트에 참여한 인원의 워커넘으로 부서조회 후 기계팀이면 새로운 리스트에 저장
		for (CommitWorker cw : thisList) {
			Worker worker = workerDAO.selectOneWorker(cw.getWorker_num());
			if (worker.getDivision_num() == 4) {
				thisMachineList.add(cw);
			}
		}
		// 현재 날짜 생성후 commitWorker의 end_date와 비교
		int cnt = 0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		String date = format.format(currentTime);

		for (CommitWorker cw : thisMachineList) {
			int result = date.compareTo(cw.getEnd_date());
			if (result > 0) {
				cnt++;
			}
		}
		// 이 프로젝트 기계팀 중에 투입날짜 끝난 인원의 비율
		if (thisMachineList.size() == 0) {
			int machineProgress = 0;
			return machineProgress;

		} else {
			int machineProgress = Math.round((cnt / thisMachineList.size()) * 100);
			return machineProgress;
		}
	}

	@Override
	public int projectsProgress(int projects_num) {

		List<CommitWorker> commitWorkerList = commitWorkerDAO.selectAll();
		List<CommitMaterial> commitMaterialList = commitMaterialDAO.selectAll();

		List<CommitWorker> thisCWList = new ArrayList<>();
		List<CommitMaterial> thisCMList = new ArrayList<>();
		// 현재 프로젝트에 투입되야하는 워커 전체
		for (CommitWorker cw : commitWorkerList) {
			if (cw.getProjects_num() == projects_num) {
				thisCWList.add(cw);
			}
		}
		// 현재 프로젝트에 투입되야하는 자재 전체
		for (CommitMaterial cm : commitMaterialList) {
			if (cm.getProjects_num() == projects_num) {
				thisCMList.add(cm);
			}
		}

		int workerProgress = 0;
		int materialProgress = 0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		String date = format.format(currentTime);

		// 투입된 워커 엔드데이트랑 현재날짜 비교 후 진행도 +
		for (CommitWorker cw : thisCWList) {
			if (date.compareTo(cw.getEnd_date()) > 0) {
				workerProgress++;
			}
		}
		// 투입자재 날짜와 현재 날짜 비교후 진행도 +
		for (CommitMaterial cm : thisCMList) {
			if (date.compareTo(cm.getCommit_date()) > 0) {
				materialProgress++;
			}
		}
		// 두가지 진행도를 각각 50이라고 가정하고 프로젝트 진행도 계산
		if (thisCWList.size() == 0 || thisCMList.size() == 0) {
			int projectsProgress = 0;
			return projectsProgress;
		} else {
			int projectsProgress = Math
					.round((workerProgress / thisCWList.size()) * 50 + (materialProgress / thisCMList.size()) * 50);

			return projectsProgress;
		}
	}

}
