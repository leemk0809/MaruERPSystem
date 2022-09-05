package net.softsociety.maru.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.maru.domain.Material;

@Mapper
public interface MaterialDAO {
	
	int insert(Material material);
	
	int delete(int material_num);
	
	int update(Material material);
	
	Material selectOne(int material_num);
	
	ArrayList<Material> selectAll();
}
