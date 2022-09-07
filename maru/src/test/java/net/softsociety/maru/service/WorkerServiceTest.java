package net.softsociety.maru.service;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Worker;
import net.softsociety.maru.service.manage.WorkerService;

@Slf4j
@SpringBootTest
public class WorkerServiceTest {
	
	@Autowired
	WorkerService service;
	
	
	@Test
	void selectOneWorker() {		
		Worker worker = service.selectOneWorker(2);
		log.debug("사원 : {}",worker);
	}	
	
	@Test
	void selectAllWorker() {
		ArrayList<Worker> al= service.selectAllWorker(3);
		log.debug("부서별 사원리스트 : {}",al);
	}
	
	
}
