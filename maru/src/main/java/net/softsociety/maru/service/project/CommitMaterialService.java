package net.softsociety.maru.service.project;

import java.util.List;

import net.softsociety.maru.domain.CommitMaterial;
import net.softsociety.maru.domain.NeedMaterial;

public interface CommitMaterialService {

	int insertCommitMaterial(CommitMaterial commitMaterial);
	
	List<CommitMaterial> selectAllCommitMaterial();

	int deleteCommitMaterial(int commitMaterial_num);
	
	CommitMaterial selectOne(int commitMaterial_num);
	
	//category 추가후 생성하기
	List<CommitMaterial> selectCommitMaterialByCategory(String category);
		
	List<CommitMaterial> thisCommitMaterialList(int projects_num);
	
	List<NeedMaterial> thisNeedMaterialList(int projects_num);
}
