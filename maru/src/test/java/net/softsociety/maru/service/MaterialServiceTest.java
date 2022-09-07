package net.softsociety.maru.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.service.project.MaterialService;

@SpringBootTest
@Slf4j
public class MaterialServiceTest {

	@Autowired
	MaterialService service;
	
	@Test
	void addMaterial(){
		Map<Integer,Integer> request = new HashMap<>();
		
		request.put(1, 10);
		request.put(2, 20);
		service.addMaterial(request);
	}
	
	@Test
	void subtractMaterial(){
		Map<Integer,Integer> request = new HashMap<>();
		
		request.put(1, 10);
		request.put(2, 20);
		service.subtractMaterial(request);
	}
}
