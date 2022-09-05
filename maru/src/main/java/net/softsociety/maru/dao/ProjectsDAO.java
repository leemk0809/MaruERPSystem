package net.softsociety.maru.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.maru.domain.Projects;

@Mapper
public interface ProjectsDAO {
	int insert(Projects projects);
	
	int delete(int projects_num);
	
	int update(int projects_num);
	
	int selectOne(int projects_num);
	
	ArrayList<Projects> selectAll();
}
