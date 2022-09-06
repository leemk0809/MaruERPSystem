package net.softsociety.maru.dao;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Issue;

@Slf4j
@SpringBootTest
public class IssueDAOTest {
	
	@Autowired
	IssueDAO dao;
	
	@Test
	void selectAll() {
		List<Issue> list = dao.selectAll();	
		log.debug("list : {}", list);
	}
	
	@Test
	void selectOne() {
		dao.selectOne(1);
	}
	

	@Test 
	void insert() {
		dao.insert(new Issue(0,1,1,3,"daoTest","test",""));
	}
	
	@Disabled
	@Test
	void update() {
		Issue i = dao.selectOne(22);
		i.setContents("asdfasdf");
		dao.update(i);
	}
	
	@Disabled
	@Test
	void delete() {
		dao.delete(21);
	}
}