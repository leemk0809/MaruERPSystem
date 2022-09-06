package net.softsociety.maru.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.maru.domain.Division;
import net.softsociety.maru.domain.Issue;

@Mapper
public interface IssueDAO {
	int insert(Issue issue);
	int delete(int issue_num);
	int update(Issue issue);
	Issue selectOne(int issue_num);
	List<Issue> selectAll();
}
