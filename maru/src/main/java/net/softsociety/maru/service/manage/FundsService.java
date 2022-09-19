package net.softsociety.maru.service.manage;

import java.util.ArrayList;

import net.softsociety.maru.domain.Projects;

public interface FundsService {
	
	//현재 총 자산(초기자본금 + 프로젝트별 수입)
	int AllFunds();
	
	//분기별 매출(프로젝트별 수입 : startdate때 50% + enddate때 50%을 날짜로 잘 자르기)
	ArrayList<Integer> quarterlySales(int year);
	
	//분기별 지출 (각종 지출 내역 총 합sum)
	ArrayList<Integer> quarterlyExpense(int year);
	
	//분기별 순이익 (수입 - 지출) 은 컨트롤러로 하겠습니다^^
	
	//프로젝트별 수입(프로젝트 수입)
	int projectSales(int projects_num);
	
	//프로젝트별 지출 (각종 지출 내역 총 합sum)
	int projectExpense(int projects_num);
	
	//프로젝트별 순이익 (수입 - 지출)  은 컨트롤러로 하겠습니다^^
	
	//프로젝트 내 지출 비율
	ArrayList<Integer> projectExpenseRate(int projects_num);

}
