package net.softsociety.maru.service;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.service.project.ProjectInfoService;

@SpringBootTest
@Slf4j
public class ProjectsInfoServiceTest {

	@Autowired
	ProjectInfoService service;
	
	@Test
	void selectAllProjects() {
		ArrayList<Projects> list = service.selectAllProjects();
		
		log.debug("리스트 목록 :{}",list);
	}
	
	@Disabled
	@Test
	void selectOneProject() {
		
		Projects projects = service.selectOne(1);
		
		log.debug("프로젝트 정보:{}",projects);
	}
	
	@Disabled
	@Test
	void buildingProgress() {
		
		int progress = service.buildingProgress(26);
		
		log.debug("건축팀진척도:{}",progress);
	}
	
	@Disabled
	@Test
	void civilEngineeringProgress() {
		
		int progress = service.civilEngineeringProgress(26);
		
		log.debug("토목팀진척도:{}",progress);
	}
	
	@Disabled
	@Test
	void electricityProgress() {
		
		int progress = service.electricityProgress(26);
		
		log.debug("전기팀진척도:{}",progress);
	}
	
	
	@Test
	void machineProgress() {
		
		int progress = service.machineProgress(26);
		
		log.debug("기계팀진척도:{}",progress);
	}
	
	@Disabled
	@Test
	void projectsProgress() {
		
		int progress = service.projectsProgress(26);
		
		log.debug("프로젝트진척도:{}",progress);
	}
}
