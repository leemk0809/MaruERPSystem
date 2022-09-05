package net.softsociety.maru.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.maru.domain.BuildingType;

@Mapper
public interface BuildingTypeDAO {
	
	int insert(BuildingType building_type);
	
	int delete(int building_type_num);
	
	int update(int building_type_num);
	
	BuildingType selectOne(int building_type_num);
	
	ArrayList<BuildingType> selectAll();
}
