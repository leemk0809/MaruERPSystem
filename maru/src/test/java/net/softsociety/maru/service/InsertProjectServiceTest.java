package net.softsociety.maru.service;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Material;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.service.project.InsertProjectService;

@SpringBootTest
@Slf4j
public class InsertProjectServiceTest {

	@Autowired
	InsertProjectService service;
	
	@Test
	void selectProjectByStatusBefore() {
		List<Projects> list = service.selectProjectByStatusBefore();
		
		log.debug("list : {}", list);
		log.debug("list.size() : {}", list.size());
	}
	
	@Test @Disabled
	void updateProject() {
		List<Material> materialList = service.selectAllMaterial();
		log.debug("materialList : {}", materialList);
		
		//유저에게 진행전 상태인 프로젝트를 보여줌
		List<Projects> projectList = service.selectProjectByStatusBefore();
		log.debug("projectList : {}", projectList);
		
		// 유저가 선택한 프로젝트를 가져옴.
		Projects project = projectList.get(0);
		log.debug("project: {}", project);
		
		// 먼저 필요 자재부터 추가 해야 함, 유저에게 projects_num, material_num, count 받아야함
		service.insertNeedMaterial(26, 1, 20);
		service.insertNeedMaterial(26, 2, 10);
	
		// 예상 지출 추가
		// 평균임금 * 필요인원수 + 필요자재갯수 * 자재가격
		// 필요자재 : 콘크리트20*650, 시멘트10*60
		// 26번 현장
		log.debug("averageSalry : {}",service.averageSalry()); 
		log.debug("calcNeedMaterialPrice : {}", service.calcNeedMaterialPrice(26));
		
		// 예상 지출 : 평균임금 + 필요자재
		int budget = service.averageSalry() + service.calcNeedMaterialPrice(26);
		log.debug("budget : {}", budget);
		
		project.setStatus("진행중");
		//service.updateProject(project);
	}
	
	@Test
	void insertNeedMaterial() {
		service.insertNeedMaterial(26, 1, 10000);
	}
}
