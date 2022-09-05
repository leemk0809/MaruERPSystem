package net.softsociety.maru.dao;

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
	
	@Test
	void insert() {
			
		BuildingType build = new BuildingType(11,"aaa");
		dao.insert(build);
	}
	
	@Test
	void delete() {
		dao.delete(2);
	}
	
	@Test
	void update() {
		dao.update(1);
	}
	
	@Test
	void selectOne() {
		dao.selectOne(2);
	}
	
	@Test
	void selectAll() {
		dao.selectAll();
	}
}
