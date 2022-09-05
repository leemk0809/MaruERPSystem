package net.softsociety.maru.dao;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Division;

@Slf4j
@SpringBootTest
public class DivisionDAOTest {
	
	@Autowired
	DivisionDAO dao;
	
	@Test
	void selectAll() {
		List<Division> list = dao.selectAll();	
		log.debug("list : {}", list);
	}
	
	@Test
	void selectOne() {
		dao.selectOne(1);
	}
	
	@Disabled
	@Test
	void insert() {
		dao.insert(new Division(999, "나의것"));
	}
	
	@Disabled
	@Test
	void delete() {
		dao.delete(999);
	}
	
	@Test
	void update() {
		Division d = dao.selectOne(999);
		d.setDivision_name("update테스트");
		dao.update(d);
	}
}