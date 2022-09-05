package net.softsociety.maru.dao;

import java.util.List;

import net.softsociety.maru.domain.CommitWorker;

public interface CommitWorkerDAO {
	int insert(CommitWorker cw);
	int delete(int commit_worker_num);
	int update(CommitWorker cw);
	List<CommitWorker> selectAll();
	CommitWorker selectOne();
}
