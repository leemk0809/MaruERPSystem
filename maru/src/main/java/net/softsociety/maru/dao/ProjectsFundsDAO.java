package net.softsociety.maru.dao;

import java.util.List;

import net.softsociety.maru.domain.ProjectsFunds;

public interface ProjectsFundsDAO {
	int insert(ProjectsFunds pf);
	int delete(int projects_funds_num);
	int update(ProjectsFunds pf);
	List<ProjectsFunds> selectAll();
	ProjectsFunds selectOne();
}
