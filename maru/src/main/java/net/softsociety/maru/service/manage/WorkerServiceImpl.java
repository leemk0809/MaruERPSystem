package net.softsociety.maru.service.manage;

import java.util.ArrayList;
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
	public void insertWorker(Worker worker) {
		dao.insertWorker(worker);
	}

	@Override
	public Worker selectOneWorker(int worker_num) {
		return dao.selectOneWorker(worker_num);
	}

	@Override
	public ArrayList<Worker> selectAllWorker(int division_num) {
		return dao.selectAllWorker(division_num);
	}

	@Override
	public void updateWorker(Worker worker) {
		dao.updateWorker(worker);
	}

	@Override
	public int deleteWorker(int worker_num) {
		return dao.deleteWorker(worker_num);
	}

	@Override
	public List<Worker> selectAll() {
		return dao.selectAll();
	}
	
}
