package net.softsociety.maru.dao;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.ProjectsTag;
import net.softsociety.maru.domain.Worker;

@Slf4j
@SpringBootTest
public class ProjectsTagDAOTest {

	@Autowired
	ProjectsTagDAO dao;
	
	@Disabled
	@Test
	public void insert() {
		ProjectsTag pt = new ProjectsTag();
		pt.setProjects_num(1);
		pt.setPosition_num(1);
		pt.setTag_sign("NO");
		
		dao.insert(pt);
	}
	
	@Disabled
	@Test
	public void update() {
		ProjectsTag pt = dao.selectOne(1);
		log.debug(pt+"");
		pt.setTag_sign("YES");
		dao.update(pt);
	}
	
	@Disabled
	@Test
	public void delete() {
		int result = dao.delete(1);
		log.debug(result+"");
	}
	
	@Disabled
	@Test
	public void selectOne() {
		ProjectsTag w = dao.selectOne(2);
		log.debug(""+w);
	}
	
	@Disabled
	@Test
	public void selectAll() {
		ArrayList<ProjectsTag> w = dao.selectAll();
		log.debug(""+w);
	}
	
}
