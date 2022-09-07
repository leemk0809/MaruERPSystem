package net.softsociety.maru.service.manage;

import java.util.ArrayList;
import java.util.List;

import net.softsociety.maru.domain.Worker;

public interface WorkerService {
	//사원 추가(사원정보 전부 입력)
	void insertWorker(Worker worker);
	
	//사원 검색(이름/사원번호 로 검색가능)
	Worker selectOneWorker(int worker_num);
	
	//부서별 사원리스트 출력()
	ArrayList<Worker> selectAllWorker(int division_num);
	
	//사원 수정(검색하면 이름 옆에 수정버튼 : 사번 외에 정보 수정)
	void updateWorker(Worker worker);	
	
	//사원 삭제(검색하면 이름 옆에 삭제버튼 : 클릭시 삭제)
	int deleteWorker(int worker_num);
	
	//사원 전체 리스트 출력
	List<Worker> selectAll();
}
