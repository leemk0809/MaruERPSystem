package net.softsociety.maru.service;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Material;
import net.softsociety.maru.domain.NeedMaterial;
import net.softsociety.maru.service.manage.LackMaterialService;

@SpringBootTest
@Slf4j
public class LackMaterialServiceTest {

	@Autowired
	LackMaterialService service;

	@Test
	void selectAllLackMaterial(){
		List<NeedMaterial> list = service.selectAllLackMaterial();
		log.debug("list : {}", list);
	}
	
	@Test
	void selectAllCommitDate() {
		List<String> list = service.selectAllCommitDate();
		log.debug("list: {}", list);
	}
	
	
}
