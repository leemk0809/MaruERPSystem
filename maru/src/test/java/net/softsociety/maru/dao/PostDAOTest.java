package net.softsociety.maru.dao;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Post;

@SpringBootTest
@Slf4j
public class PostDAOTest {

	@Autowired
	PostDAO dao;
	
	@Test
	void insert() {
		Post post = new Post(12,"hi",2,10,10,10);
		log.debug("post: {}",post);
		dao.insert(post);
	}
	
	@Disabled
	@Test
	void update() {
		Post post = new Post(5,"hi",2,1,3,2);
		dao.update(post);
	}
	
	@Disabled
	@Test
	void delete() {
		dao.delete(5);
	}
	
	@Disabled
	@Test
	void selectOne() {
		dao.selectOne(2);
	}
	
	@Disabled
	@Test
	void selectAll() {
		dao.selectAll();
	}
}
