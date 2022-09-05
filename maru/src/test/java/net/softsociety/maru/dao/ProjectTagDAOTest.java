package net.softsociety.maru.dao;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.ProjectTag;
import net.softsociety.maru.domain.Worker;

@Slf4j
@SpringBootTest
public class ProjectTagDAOTest {

	@Autowired
	ProjectTagDAO dao;
	
	@Test
	public void insert() {
		ProjectTag pt = new ProjectTag();
		pt.setProject_num(1);
		pt.setPosition_num(1);
		pt.setTag_sign("NO");
		
		dao.insert(pt);
	}
	
	@Test
	public void delete() {
		int result = dao.delete(1);
		log.debug(result+"");
	}
	
	@Test
	public void update() {
		ProjectTag pt = dao.selectOne(1);
		pt.setTag_sign("YES");
	}
	
	@Test
	public void selectOne() {
		ProjectTag w = dao.selectOne(2);
		log.debug(""+w);
	}
	
	@Test
	public void selectAll() {
		ArrayList<ProjectTag> w = dao.selectAll();
		log.debug(""+w);
	}
	
}
