package net.softsociety.maru.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.maru.domain.BuildingType;

@Mapper
public interface BuildingTypeDAO {
	
	int insert(BuildingType buildingtype);
	
	int delete(int building_type_num);
	
	int update(BuildingType buildingtype);
	
	BuildingType selectOne(int building_type_num);
	
	ArrayList<BuildingType> selectAll();
}
