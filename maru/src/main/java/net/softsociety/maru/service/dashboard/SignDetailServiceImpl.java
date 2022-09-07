package net.softsociety.maru.service.dashboard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.dao.ProjectsDAO;
import net.softsociety.maru.dao.ProjectsTagDAO;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.domain.ProjectsTag;

@Slf4j
@Service
public class SignDetailServiceImpl implements SignDetailService {

	@Autowired
	ProjectsDAO pdao;
	
	@Autowired
	ProjectsTagDAO ptdao;
	
	@Override
	public Projects selecOne(int projects_num) {
		Projects p = pdao.selectOne(projects_num);
		//log.debug(" 프로젝트 "+p);
		return p;
	}

	@Override
	public int stamp(int position_num) {
		
		ArrayList<ProjectsTag> ptList = ptdao.selectAll();
		ProjectsTag pt = null;
		
		for(ProjectsTag pttmp : ptList) {
			if(pttmp.getPosition_num()==position_num) {
				pt = pttmp;
			}
		}
		pt.setTag_sign("Y");
		
		return ptdao.update(pt);
	}

}
