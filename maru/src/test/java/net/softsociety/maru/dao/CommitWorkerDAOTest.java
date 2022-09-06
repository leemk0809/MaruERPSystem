package net.softsociety.maru.dao;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.CommitWorker;
import net.softsociety.maru.domain.Division;

@Slf4j
@SpringBootTest
public class CommitWorkerDAOTest {
	
	@Autowired
	CommitWorkerDAO dao;
	
	@Test
	void selectAll() {
		List<CommitWorker> list = dao.selectAll();	
		log.debug("list : {}", list);
	}
	
	@Test 
	void selectOne() {
		dao.selectOne(2);
	}
	
	@Disabled
	@Test
	void insert() {
		dao.insert(new CommitWorker(0, 1, 1, "아소비", "2022-09-01", "2022-09-03"));
	}
	
	@Disabled
	@Test
	void delete() {
		dao.delete(21);
	}
	
	@Test @Disabled 
	void update() {
		CommitWorker cw = dao.selectOne(22);
		cw.setWorker_detail("빡근무");
		log.debug("cw:{}",cw);
		dao.update(cw);
	}
}