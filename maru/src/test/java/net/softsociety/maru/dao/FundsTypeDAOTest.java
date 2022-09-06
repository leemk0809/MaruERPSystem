package net.softsociety.maru.dao;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Division;
import net.softsociety.maru.domain.FundsType;

@Slf4j
@SpringBootTest
public class FundsTypeDAOTest {
	
	@Autowired
	FundsTypeDAO dao;
	
	@Test
	void selectAll() {
		List<FundsType> list = dao.selectAll();	
		log.debug("list : {}", list);
	}
	
	@Test
	void selectOne() {
		dao.selectOne(1);
	}
	
	@Test
	void insert() {
		dao.insert(new FundsType(999,"daoTest"));
	}
	
	@Test
	void update() {
		FundsType ft = dao.selectOne(999);
		ft.setFunds_type_name("update테스트");
		dao.update(ft);
	}
	
	@Test
	void delete() {
		dao.delete(999);
	}
}