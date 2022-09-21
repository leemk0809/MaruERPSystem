package net.softsociety.maru.service.manage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.dao.DivisionDAO;
import net.softsociety.maru.dao.PositionDAO;
import net.softsociety.maru.dao.WorkerDAO;
import net.softsociety.maru.domain.Division;
import net.softsociety.maru.domain.Position;
import net.softsociety.maru.domain.Worker;

@Slf4j
@Service
@Transactional
public class WorkerServiceImpl implements WorkerService{
		
	@Autowired
	WorkerDAO Wdao;
	
	@Autowired
	DivisionDAO Ddao;
	
	@Autowired
	PositionDAO Pdao;
	
	@Override
	public void insertWorker(Worker worker) {
		Wdao.insertWorker(worker);
	}

	@Override
	public Worker selectOneWorker(int worker_num) {
		return Wdao.selectOneWorker(worker_num);
	}

	@Override
	public ArrayList<Worker> selectAllWorker(int division_num) {
		return Wdao.selectAllWorker(division_num);
	}

	@Override
	public void updateWorker(Worker worker) {
		Wdao.updateWorker(worker);
	}

	@Override
	public int deleteWorker(int worker_num) {
		return Wdao.deleteWorker(worker_num);
	}

	@Override
	public List<Worker> selectAll() {
		return Wdao.selectAll();
	}

	@Override
	public List<Division> divisionList() {
		return Ddao.selectAll();
	}

	@Override
	public List<Position> positionList() {
		return Pdao.selectAll();
	}


	
	
	
}
