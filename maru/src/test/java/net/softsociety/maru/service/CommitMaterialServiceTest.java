package net.softsociety.maru.service;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.CommitMaterial;
import net.softsociety.maru.service.project.CommitMaterialService;

@SpringBootTest
@Slf4j
public class CommitMaterialServiceTest {

	@Autowired
	CommitMaterialService service;
	
	@Disabled
	@Test
	void insertMaterial() {
		
		CommitMaterial commitMaterial = new CommitMaterial(22, 17, 3, 10,"2022-01-01");
		
		int result = service.insertCommitMaterial(commitMaterial);
		
		log.debug("자재일정추가결과 :{}",result);
		
	}
	
	
	@Test
	void selectAllCommitMaterial() {
		
		List<CommitMaterial> commitMaterialList = service.selectAllCommitMaterial();
		
		log.debug("자재투입 전체:{}",commitMaterialList);
		
		log.debug("리스트 사이즈:{}",commitMaterialList.size());
	}
	
	@Test
	void selectOne() {
		
		CommitMaterial commitMaterial = service.selectOne(1);
		
		log.debug("투입자재 상세내역:{}", commitMaterial);
	}
	
	@Test
	void deleteCommitMaterial() {
		
		int result = service.deleteCommitMaterial(1);
		
		log.debug("삭제완료 : {}",result);
	}

//	@Test
//	void selectCommitMaterialByCategory() {
//		
//		List<CommitMaterial> list = service.selectCommitMaterialByCategory("category");
//		
//		log.debug("",list);
//				
//	}
	
}
