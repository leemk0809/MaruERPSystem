package net.softsociety.maru.service.manage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.dao.FundsTypeDAO;
import net.softsociety.maru.dao.ProjectsDAO;
import net.softsociety.maru.dao.ProjectsFundsDAO;
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
	public int projectsAllFunds() {

		int BaseAmount = 10000;
		int projectsAmount = 0;
		
		List<Projects> projectsList = pdao.selectAll();
		
		for(Projects projects : projectsList) {
			projectsAmount += projects.getAmount();
		}
		
		int total = BaseAmount + projectsAmount;
		
		return total;
	}


	@Override
	public int quarterlySales(int projects_num) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int quarterlyBasis(int projects_funds_num) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}
