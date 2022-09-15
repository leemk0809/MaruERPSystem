package net.softsociety.maru.dao;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
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
	
	@Disabled
	@Test
	void insert() {
			
		Material material = new Material(11,"aaa",11,11);
		dao.insert(material);
	}
	
	@Disabled
	@Test
	void delete() {
		dao.delete(2);
	}
	
	@Disabled
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
	
	@Test
	void selectAllByNum() {
		dao.selectAllByNum();
	}
	
	@Test
	void selectAllByName() {
		dao.selectAllByName();
	}
	
	@Test
	void selectAllByPrice() {
		dao.selectAllByPrice();
	}

	@Test
	void selectAllByCount() {
		dao.selectAllByCount();
	}
}
