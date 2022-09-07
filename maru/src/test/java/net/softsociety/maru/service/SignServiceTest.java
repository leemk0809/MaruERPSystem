package net.softsociety.maru.service;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.domain.ProjectsTag;
import net.softsociety.maru.service.dashboard.SignService;

@Slf4j
@SpringBootTest
public class SignServiceTest {
	
	@Autowired
	SignService service;
	
	@Test
	void selectAllProjectsTag() {
		ArrayList<ProjectsTag> list = service.selectAllProjectsTag();
		
		log.debug("Tag List : {} ",list);
	}
	
	@Test
	void selectAllProjects() {
		ArrayList<Projects> list = service.selectAllProjects();
		
		log.debug("Projects List : {}",list);
	}	
	
}
