package net.softsociety.maru.service.dashboard;

import net.softsociety.maru.domain.Projects;

public interface SignDetailService {

	//프로젝트 전제 정보를 보기위한 메소드
	public Projects selecOne(int projects_num);
	
	//도장을 찍으면 프로젝트 프로젝트태그의 TAG_SIGN저장값 변경하기위한 메소드
	public int stamp(int worker_num, int projects_num);
	
}
