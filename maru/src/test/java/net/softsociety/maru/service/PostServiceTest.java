package net.softsociety.maru.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Post;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.service.dashboard.PostService;

@SpringBootTest
@Slf4j
public class PostServiceTest {

	@Autowired
	PostService service;
	
	@Test
	void selctAllPost() {
		
		List<Post> postList = service.selectAllPost();
		
		log.debug("포스트리스트 :{}", postList);
		log.debug("리스트 사이즈:{}",postList.size());
	}
	
	@Test
	void insertProjects() {
		
		Projects projects = new Projects(13,26,"hi","2022-12-22","2024-10-23","진행중",20,200,"hi","hi");
		
		log.debug("입력할 프로젝트 :{}", projects);
		
		int result = service.insertProjects(projects);

		log.debug("insert 결과 : {}",result);
	}
	
}
