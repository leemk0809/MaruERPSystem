package net.softsociety.maru.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.service.dashboard.SignDetailServiceImpl;

@Slf4j
@SpringBootTest
public class SignDetailServiceTest {

	@Autowired
	SignDetailServiceImpl service;
	
	@Disabled
	@Test
	public void selecOne() {
		log.debug("프로젝트 : " + service.selecOne(1));
	}
	
	@Disabled
	@Test
	public void stamp() {
		service.stamp(2,1);
	}
	
}
