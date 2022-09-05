package net.softsociety.maru.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Material;

@SpringBootTest
@Slf4j
public class MaterialDAOTest {

	@Autowired
	MaterialDAO dao;
	
	@Test
	void insert() {
			
		Material material = new Material(11,"aaa",11,11);
		dao.insert(material);
	}
	
	@Test
	void delete() {
		dao.delete(2);
	}
	
	@Test
	void update() {
		Material material = new Material(11, "bbb", 12,12);
		dao.update(material);
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
