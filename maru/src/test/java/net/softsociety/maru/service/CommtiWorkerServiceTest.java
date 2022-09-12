package net.softsociety.maru.service;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.CommitWorker;
import net.softsociety.maru.domain.Worker;
import net.softsociety.maru.service.project.CommitWorkerService;

@Slf4j
@SpringBootTest
public class CommtiWorkerServiceTest {

	@Autowired
	CommitWorkerService service;
	
	@Disabled
	@Test
	public void selectAllCommitWorker() {
		List<CommitWorker> list = service.selectAllCommitWorker();
		
		//log.debug("리스트 확인" + list);
	}
	
	@Disabled
	@Test
	public void selectAllWorker() {
		List<Worker> list = service.selectAllWorker();
		
		//log.debug("리스트 확인" + list);
	}
	
	@Disabled
	@Test
	public void insert() {
		CommitWorker cw = new CommitWorker();
		
		cw.setCommit_date("2022/09/12");
		cw.setEnd_date("2020/09/13");
		cw.setProjects_num(1);
		cw.setWorker_detail("농땡이");
		cw.setWorker_num(4);
		
		//log.debug(cw+ "");
		
		int result = service.insert(cw);
		//log.debug("result : " + result);
	}
	
	@Disabled
	@Test
	public void delete() {
		
		int result = service.delete(3);
		
		//log.debug("result : " + result); 
	}
}
