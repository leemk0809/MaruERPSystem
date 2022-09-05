package net.softsociety.maru.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.maru.domain.NeedMaterial;

@Mapper
public interface NeedMaterialDao {

	public int insert(NeedMaterial needMaterial);
	
	public int delete(int need_material_num);
	
	public int update(NeedMaterial needMaterial);
	
	public NeedMaterial selectOne(int need_material_num);
	
	public ArrayList<NeedMaterial> selectAll();
}
