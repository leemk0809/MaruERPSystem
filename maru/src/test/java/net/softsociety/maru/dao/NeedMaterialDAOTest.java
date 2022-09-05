package net.softsociety.maru.dao;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.NeedMaterial;
import net.softsociety.maru.domain.Worker;

@Slf4j
@SpringBootTest
public class NeedMaterialDAOTest {

	@Autowired
	NeedMaterialDAO dao;
	
	@Test
	public void insert() {
		NeedMaterial nm = new NeedMaterial();
		nm.setMaterial_num(1);
		nm.setProject_num(1);
		nm.setCount(11);
		
		dao.insert(nm);
	}
	
	@Disabled
	@Test
	public void delete() {
		int result = dao.delete(1);
		log.debug(result+"");
	}
	
	@Disabled
	@Test
	public void update() {
		NeedMaterial nm = new NeedMaterial();
	}
	
	@Disabled
	@Test
	public void selectOne() {
		NeedMaterial w = dao.selectOne(2);
		log.debug(""+w);
	}
	
	@Disabled
	@Test
	public void selectAll() {
		ArrayList<NeedMaterial> w = dao.selectAll();
		log.debug(""+w);
	}
	
}
