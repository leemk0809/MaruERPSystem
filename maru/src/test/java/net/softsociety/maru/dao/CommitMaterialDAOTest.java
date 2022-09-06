package net.softsociety.maru.dao;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.CommitMaterial;

@Slf4j
@SpringBootTest
public class CommitMaterialDAOTest {

	@Autowired
	CommitMaterialDAO dao;
	
	@Test
	void selectOne() {
		dao.selectOne(5);
	}
	
	@Test
	void selectAll() {
		List<CommitMaterial> list= dao.selectAll();
		log.debug("list:{}", list);
	}
	
	@Disabled
	@Test
	void insert() {
		CommitMaterial cm = new CommitMaterial(5,2,2,100,"1993-02-01");
		dao.insert(cm);
	}
	
	@Disabled
	@Test
	void update() {
		CommitMaterial cm = dao.selectOne(5);
		cm.setCount(50);
		dao.update(cm);
	}
	
	@Disabled
	@Test
	void delete() {
		dao.delete(5);
	}


}
