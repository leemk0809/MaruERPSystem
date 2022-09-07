package net.softsociety.maru.service.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.dao.WorkerDAO;
import net.softsociety.maru.domain.Worker;

@Slf4j
@Service
@Transactional
public class WorkerServiceImpl implements WorkerService{
	
	
	@Autowired
	WorkerDAO dao;
	
	@Override
	public int insertWorker(Worker worker) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Worker selectOneWorker(int worker_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Worker> selectAllWorker(int division_num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateWorker(Worker worker) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteWorker(int worker_num) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
