package net.softsociety.maru.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Projects;

@SpringBootTest
@Slf4j
public class ProjectsDAOTest {

	@Autowired
	ProjectsDAO dao;
	
	@Test
	void insert() {
			
		Projects projects = new Projects(3,11,"aaa","aaa","2022-12-12","2023-01-01",11,11,"aaa","aaa");
		dao.insert(projects);
	}
	
//	@Test
//	void delete() {
//		dao.delete(2);
//	}
//	
//	@Test
//	void update() {
//		Projects projects = new Projects(2,11,"aaa","aaa","2022-12-12","2023-01-01",11,11,"aaa","aaa");
//		dao.update(projects);
//	}
//	
//	@Test
//	void selectOne() {
//		dao.selectOne(2);
//	}
//	
//	@Test
//	void selectAll() {
//		dao.selectAll();
//	}
}
