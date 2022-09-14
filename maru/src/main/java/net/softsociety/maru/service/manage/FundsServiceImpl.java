package net.softsociety.maru.service.manage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.dao.FundsTypeDAO;
import net.softsociety.maru.dao.ProjectsDAO;
import net.softsociety.maru.dao.ProjectsFundsDAO;
import net.softsociety.maru.domain.CommitWorker;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.domain.ProjectsFunds;

@Slf4j
@Service
@Transactional
public class FundsServiceImpl implements FundsService{
	
	@Autowired
	ProjectsFundsDAO pfdao;	
	@Autowired
	FundsTypeDAO ftdao;	
	@Autowired
	ProjectsDAO pdao;
	

	@Override
	public int AllFunds() {

		int BaseAmount = 7000;		//초기자본금(단위: 억)
		int projectsAmount = 0;		//프로젝트별 수입
		
		List<Projects> projectsList = pdao.selectAll();
		
		for(Projects projects : projectsList) {
			projectsAmount += projects.getAmount();
		}
		
		int total = BaseAmount + projectsAmount;
		
		return total;
	}


	@Override
	public ArrayList<Integer> quarterlySales(int year) {				//연도에 따른 분기별 수입
		
		ArrayList<Integer> quarterlySales = new ArrayList<>();

		int sales1 = 0;
		int sales2 = 0;
		int sales3 = 0;
		int sales4 = 0;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();												//오늘날짜
		String date = format.format(today);	
		
		
		ArrayList<Projects> allProjectsList = pdao.selectAll();

		
		for(Projects projects : allProjectsList) {
			String endDate = projects.getEnd_date().toString();
			
			int result = date.compareTo(endDate);					//오늘 날짜랑 프로젝트 끝나는 날짜랑 비교
			
			int pyear = Integer.parseInt(endDate.substring(0,4));
			int pmonth = Integer.parseInt(endDate.substring(5,7));
			
			if(pyear==year&& result<=0) {							//연도가 입력연도랑 같고 (필수조건), 아직 프로젝트 안끝났을때
				switch(pmonth) {
					case 1: case 2: case 3:
							sales1 += (projects.getAmount())*0.5;
							break;
					case 4: case 5: case 6:
							sales2 += (projects.getAmount())*0.5;
							break;
					case 7: case 8: case 9:
							sales3 += (projects.getAmount())*0.5;
							break;
					case 10: case 11: case 12:
							sales4 += (projects.getAmount())*0.5;
							break;				
				}
			}
			else if(pyear==year&& result>0) {					//연도가 입력연도랑 같고 (필수조건), 프로젝트 끝났을때
				switch(pmonth) {
					case 1: case 2: case 3:
							sales1 += projects.getAmount();
							break;
					case 4: case 5: case 6:
							sales2 += projects.getAmount();
							break;
					case 7: case 8: case 9:
							sales3 += projects.getAmount();
							break;
					case 10: case 11: case 12:
							sales4 += projects.getAmount();
							break;				
				}
			}
		}
			
		quarterlySales.add(sales1);
		quarterlySales.add(sales2);
		quarterlySales.add(sales3);
		quarterlySales.add(sales4);		
		
		
		return quarterlySales;

	}

	
	
	@Override
	public ArrayList<Integer> quarterlyExpense(int year) {
		ArrayList<Integer> quarterlyExpense = new ArrayList<>();
		
		int expense1 = 0;
		int expense2 = 0;
		int expense3 = 0;
		int expense4 = 0;
		
		List<ProjectsFunds> allFundsList = pfdao.selectAll();
		
		for(ProjectsFunds PF : allFundsList) {
			String inputDate = PF.getInput_date().toString();
			
			int pyear = Integer.parseInt(inputDate.substring(0,4));
			int pmonth = Integer.parseInt(inputDate.substring(5,7));
			
			if(pyear==year) {
				switch(pmonth) {
					case 1: case 2: case 3:
							expense1 += PF.getPrice();
							break;
					case 4: case 5: case 6:
							expense2 += PF.getPrice();
							break;
					case 7: case 8: case 9:
							expense3 += PF.getPrice();
							break;
					case 10: case 11: case 12:
							expense4 += PF.getPrice();
							break;				
				}
			}			
		}
		
		quarterlyExpense.add(expense1);
		quarterlyExpense.add(expense2);
		quarterlyExpense.add(expense3);
		quarterlyExpense.add(expense4);
		
		return quarterlyExpense;
	}

	


	@Override
	public int projectSales(int projects_num) {
		
		int Amount = 0;							//한 프로젝트의 수입
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();												//오늘날짜
		String date = format.format(today);	
		
		//프로젝트 끝나는 날짜랑 오늘이랑 비교
		int result = date.compareTo(pdao.selectOne(projects_num).getEnd_date());
		//아직 안끝났을 경우  50%
		if(result < 0) {
			Amount = (int) ((pdao.selectOne(projects_num).getAmount())*0.5);
		}
		//끝났을 경우 100%
		if(result >=0) {
			Amount = pdao.selectOne(projects_num).getAmount();
		}		
				
		return Amount;
	}


	@Override
	public int projectExpense(int projects_num) {

		int expenditure =0;		//지출비용
		
		List<ProjectsFunds> PF = pfdao.selectAll();					//전체 지출내역
		List<ProjectsFunds> thispf= new ArrayList<ProjectsFunds>();	//새로 만들 지출리스트
		
		for(ProjectsFunds pjfunds: PF) {					
			if(pjfunds.getProjects_num()==projects_num) {			//지출내역에서 프로젝트 넘버 같은것만.
				thispf.add(pjfunds);								//같은 넘버들의 지출내역을 새 지출리스트에 더하기
			}
		}
		
		for(ProjectsFunds projectsfunds: thispf) {			//위에서 걸러진 새리스트에서 지출내역 더하기
			expenditure += projectsfunds.getPrice();			
		}		
		
		return expenditure;
	}


	
}	

