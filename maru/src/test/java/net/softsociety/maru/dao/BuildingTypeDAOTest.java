package net.softsociety.maru.dao;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.BuildingType;

@SpringBootTest
@Slf4j
public class BuildingTypeDAOTest {

	@Autowired
	BuildingTypeDAO dao;
	
	@Disabled
	@Test
	void insert() {
			
		BuildingType build = new BuildingType(11,"aaa");
		dao.insert(build);
	}
	
	@Disabled
	@Test
	void delete() {
		dao.delete(2);
	}
	
	@Disabled
	@Test
	void update() {
		BuildingType buildingtype = new BuildingType(1, "aaa");
		dao.update(buildingtype);
	}
	
	
	@Test
	void selectAll() {
		List<BuildingType> list = dao.selectAll();
		log.debug("list : {}", list);
	}
	
	@Test
	void selectOne() {
		dao.selectOne(2);
	}
}
