package net.softsociety.maru.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.maru.domain.ProjectTag;

@Mapper
public interface ProjectTagDAO {

	public int insert(ProjectTag projectTag);
	
	public int delete(int project_tag_num);
	
	public int update(ProjectTag projectTag);
	
	public ProjectTag selectOne(int project_tag_num);
	
	public ArrayList<ProjectTag> selectAll();
}
