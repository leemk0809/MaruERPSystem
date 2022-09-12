package net.softsociety.maru.service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.maru.dao.CommitWorkerDAO;
import net.softsociety.maru.dao.WorkerDAO;
import net.softsociety.maru.domain.CommitWorker;
import net.softsociety.maru.domain.Worker;

@Service
public class CommitWorkerServiceImpl implements CommitWorkerService {

	@Autowired
	CommitWorkerDAO cdao;
	
	@Autowired
	WorkerDAO wdao;
	
	@Override
	public List<CommitWorker> selectAllCommitWorker() {
		List<CommitWorker> list = cdao.selectAll();
		return list;
	}

	@Override
	public List<Worker> selectAllWorker() {
		List<Worker> list = wdao.selectAll();
		return list;
	}

	@Override
	public int insert(CommitWorker cw) {
		int result = cdao.insert(cw);
		return result;
	}

	@Override
	public int delete(int commit_worker_num) {
		int result = cdao.delete(commit_worker_num);
		return result;
	}

}
