package net.softsociety.maru.dao;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Position;

@Slf4j
@SpringBootTest
public class PositionDAOTest {

	@Autowired
	PositionDAO dao;
	
	@Test
	void selectAll() {
		List<Position> list = dao.selectAll();
		log.debug("list:{}",list);
	}
	
	@Test
	void selectOne() {
		dao.selectOne(1);
	}
	
	@Disabled
	@Test
	void insert() {
		dao.insert(new Position(123,"포지션"));
	}
	
	@Disabled
	@Test
	void update() {
		Position p = dao.selectOne(123);
		p.setPosition_name("update포");
		dao.update(p);
	}
	
	@Disabled
	@Test
	void delete() {
		dao.delete(123);
	}
}
