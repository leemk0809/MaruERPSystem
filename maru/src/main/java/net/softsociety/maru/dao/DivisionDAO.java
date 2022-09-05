package net.softsociety.maru.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.maru.domain.Division;

@Mapper
public interface DivisionDAO {
	int insert(Division division);
	int delete(int division_num);
	int update(Division division);
	Division selectOne(int division_num);
	List<Division> selectAll();
}
