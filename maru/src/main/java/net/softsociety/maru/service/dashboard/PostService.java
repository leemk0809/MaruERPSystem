package net.softsociety.maru.service.dashboard;

import java.util.ArrayList;

import net.softsociety.maru.domain.Post;
import net.softsociety.maru.domain.Projects;

public interface PostService {

	ArrayList<Post> selectAllPost();
	
	int insertProjects(Projects projects);
}
