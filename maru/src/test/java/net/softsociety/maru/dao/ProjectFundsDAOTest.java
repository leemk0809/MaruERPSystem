package net.softsociety.maru.dao;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.ProjectsFunds;

@Slf4j
@SpringBootTest
public class ProjectFundsDAOTest {

		@Autowired
		ProjectsFundsDAO dao;
		
		@Disabled
		@Test
		void insert() {
			ProjectsFunds pf = new ProjectsFunds(2,2,2,"자재",2000,null);
			dao.insert(pf);
		}

		@Disabled
		@Test
		void update() {			
			ProjectsFunds pf = dao.selectOne(2);
			pf.setFunds_detail("자재물");
			dao.update(pf);
		}
		
		@Disabled
		@Test
		void delete() {
			dao.delete(2);
		}
		
		
		@Test
		void selectOne() {
			dao.selectOne(2);
		}		
		
		
		@Test
		void selectAll() {
			List<ProjectsFunds> list = dao.selectAll();			
			log.debug("list: {}", list);			
		}
}
