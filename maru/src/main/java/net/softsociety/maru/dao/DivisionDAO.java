package net.softsociety.maru.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.maru.domain.Division;

@Mapper
public interface DivisionDAO {
	int insert();
	int delete();
	int update();
	Division selectOne(int division_num);
	List<Division> selectAll();
}
