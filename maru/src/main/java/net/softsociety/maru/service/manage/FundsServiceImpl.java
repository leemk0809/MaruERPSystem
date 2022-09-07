package net.softsociety.maru.service.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.dao.FundsTypeDAO;
import net.softsociety.maru.dao.ProjectsFundsDAO;

@Slf4j
@Service
@Transactional
public class FundsServiceImpl implements FundsService{
	
	@Autowired
	ProjectsFundsDAO pfdao;
	
	@Autowired
	FundsTypeDAO ftdao;
	
	
	
	
}
