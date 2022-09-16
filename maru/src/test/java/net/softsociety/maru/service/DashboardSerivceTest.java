package net.softsociety.maru.service;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Issue;
import net.softsociety.maru.service.dashboard.DashboardSerivceImpl;

@Slf4j
@SpringBootTest
public class DashboardSerivceTest {

	@Autowired
	DashboardSerivceImpl service;
	
	@Disabled
	@Test
	public void calcProgress() {
		int result = service.calcProgress(1);
	}
	
	@Disabled
	@Test
	public void calcCommitDate() {
		int result = service.calcCommitDate(1);
	}
	
	@Disabled
	@Test
	public void countProjects() {
		int result = service.countAllProjects();
	}
	
	@Disabled
	@Test
	public void countProceedingProjects() {
		int result = service.countProceedingProjects();
	}
	
	@Disabled
	@Test
	public void allissue() {
		 ArrayList<Issue> list = service.selectAllIssue();
		 log.debug(list + " ");
	}
}
