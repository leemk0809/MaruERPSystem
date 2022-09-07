package net.softsociety.maru.service.dashboard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.dao.ProjectsDAO;
import net.softsociety.maru.dao.ProjectsTagDAO;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.domain.ProjectsTag;

@Slf4j
@Service
@Transactional
public class SignServiceImpl implements SignService{
	
	@Autowired
	ProjectsTagDAO pt;
	
	@Autowired
	ProjectsDAO p;

	@Override
	public ArrayList<ProjectsTag> selectAllProjectsTag() {
		ArrayList<ProjectsTag> ptlist= pt.selectAll();
		return ptlist;
	}

	@Override
	public ArrayList<Projects> selectAllProjects() {
		ArrayList<Projects> plist = p.selectAll();
		return plist;
	}
	
	
	
}
