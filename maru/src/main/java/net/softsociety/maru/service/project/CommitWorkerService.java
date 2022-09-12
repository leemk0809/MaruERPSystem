package net.softsociety.maru.service.project;

import java.util.List;

import net.softsociety.maru.domain.CommitWorker;
import net.softsociety.maru.domain.Worker;

public interface CommitWorkerService {

	//참여인력 을보여주기위한 전체를 불러오는 메소드
	public List<CommitWorker> selectAllCommitWorker();
	
	//인력추가시 모든 사람을 보여주기위한 메소드
	public List<Worker> selectAllWorker();
	
	//참여인력을 추가하기위한 메소드
	public int insert(CommitWorker cw);
	
	//참여인력을 제거?하기위한 메소드 
	public int delete(int commit_worker_num);
}
