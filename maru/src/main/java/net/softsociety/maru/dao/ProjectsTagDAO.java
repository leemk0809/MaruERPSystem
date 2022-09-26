package net.softsociety.maru.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.maru.domain.ProjectsTag;

@Mapper
public interface ProjectsTagDAO {

	public int insert(ProjectsTag projectsTag);
	
	public int delete(int projects_tag_num);
	
	public int update(ProjectsTag projectsTag);
	
	public ProjectsTag selectOne(int projects_tag_num);
	
	public ArrayList<ProjectsTag> selectAll();
	
	public ArrayList<String> selectTag(int projects_num);
}
