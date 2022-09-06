package net.softsociety.maru.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.maru.domain.ProjectsFunds;

@Mapper
public interface ProjectsFundsDAO {
	int insert(ProjectsFunds pf);
	int delete(int projects_funds_num);
	int update(ProjectsFunds pf);
	List<ProjectsFunds> selectAll();
	ProjectsFunds selectOne(int projects_funds_num);
}