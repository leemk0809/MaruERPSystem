package net.softsociety.maru.service;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.service.manage.FundsService;

@SpringBootTest
@Slf4j
public class FundsServiceTest {

	@Autowired
	FundsService service;
	
	@Test
	void AllFunds() {
		int total = service.AllFunds();
		
		log.debug("총 자본금 : {}",total);
	}
	
	
	@Test
	void quarterlySales() {
		ArrayList<Integer> sales = service.quarterlySales(2022);
		
		log.debug("2022년 1,2,3,4 분기 매출: {}",sales);
	}
	
	
	@Test
	void quarterlyExpense() {
		ArrayList<Integer> expenses = service.quarterlyExpense(2022);
		
		log.debug("2022년 1,2,3,4 분기 지출: {}",expenses);
	}
	
	
	@Test
	void projectSales() {
		int result = service.projectSales(2);
		
		log.debug("2번 프로젝트 수입: {}",result);
	}
	
	@Test
	void projectExpense() {
		int result = service.projectExpense(1);
		
		log.debug("1번 프로젝트 지출: {}",result);
	}
	

}
