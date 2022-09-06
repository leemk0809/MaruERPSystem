package net.softsociety.maru.dao;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.NeedMaterial;

@Slf4j
@SpringBootTest
public class NeedMaterialDAOTest {

	@Autowired
	NeedMaterialDAO dao;
	
	@Disabled
	@Test
	public void insert() {
		NeedMaterial nm = new NeedMaterial();
		nm.setMaterial_num(1);
		nm.setProjects_num(1);
		nm.setCount(11);
		
		dao.insert(nm);
	}
	
	@Disabled
	@Test
	public void delete() {
		int result = dao.delete(44);
		log.debug(result+"");
	}
	
	@Disabled
	@Test
	public void update() {
		NeedMaterial nm = new NeedMaterial();
		nm.setNeed_material_num(45);
		nm.setMaterial_num(1);
		nm.setProjects_num(1);
		nm.setCount(1121);
		
		dao.update(nm);
	}

	@Disabled
	@Test
	public void selectOne() {
		NeedMaterial w = dao.selectOne(45);
		log.debug(""+w);
	}
	
	@Disabled
	@Test
	public void selectAll() {
		ArrayList<NeedMaterial> w = dao.selectAll();
		log.debug(""+w);
	}
	
}
