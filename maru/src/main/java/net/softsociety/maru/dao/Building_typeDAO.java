package net.softsociety.maru.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.maru.domain.Building_type;

@Mapper
public interface Building_typeDAO {
	
	int insert(Building_type building_type);
	
	int delete(int building_type_num);
	
	int update(int building_type_num);
	
	int selectOne(int building_type_num);
	
	ArrayList<Building_type> selectAll();
}
