package net.softsociety.maru.dao;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Worker;

@Slf4j
@SpringBootTest
public class WorkerDAOTest {

	@Autowired
	WorkerDAO dao;
	
	@Disabled
	@Test
	public void insert() {
		Worker w = new Worker();
		w.setDivision_num(1);
		w.setPosition_num(1);
		w.setName("name");
		w.setId("id1");
		w.setPassword("password1");
		w.setPhone("phone");
		w.setSalary(100);
		log.debug(w+"");
		dao.insert(w);
	}
	

	@Test
	public void delete() {
		int result = dao.delete(22);
		log.debug(result+"");
	}
	
	@Disabled
	@Test
	public void update() {
		Worker w = new Worker();
		w.setWorker_num(2);
		w.setDivision_num(1);
		w.setPosition_num(1);
		w.setName("바꿈");
		w.setId("id1");
		w.setPassword("password1");
		w.setPhone("phone");
		w.setSalary(100);

		int result = dao.update(w);
	}
	
	@Disabled
	@Test
	public void selectOne() {
		Worker w = dao.selectOne(2);
		log.debug(""+w);
	}
	
	@Disabled
	@Test
	public void selectAll() {
		ArrayList<Worker> w = dao.selectAll();
		log.debug(""+w);
	}
	
}
