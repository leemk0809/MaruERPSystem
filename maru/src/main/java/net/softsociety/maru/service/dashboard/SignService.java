package net.softsociety.maru.service.dashboard;

import java.util.ArrayList;

import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.domain.ProjectsTag;

public interface SignService {
	
	ArrayList<ProjectsTag> selectAllProjectsTag();
	
	ArrayList<Projects> selectAllProjects();

}
