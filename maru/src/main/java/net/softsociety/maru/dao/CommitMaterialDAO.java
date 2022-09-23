package net.softsociety.maru.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.softsociety.maru.domain.CommitMaterial;

@Mapper
public interface CommitMaterialDAO {
	int insert(CommitMaterial cm);
	int delete(int commit_material_num);
	int update(CommitMaterial cm);
	List<CommitMaterial> selectAll();
	CommitMaterial selectOne(int commit_material_num);
	List<CommitMaterial> thisList(int projects_num);
}
