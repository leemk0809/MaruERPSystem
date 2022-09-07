package net.softsociety.maru.service.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.dao.ProjectsDAO;

@Service
@Transactional
@Slf4j
public class ProjectInfoServiceImpl implements ProjectInfoService {

	@Autowired
	ProjectsDAO projectsDAO;
	
	
	
}
