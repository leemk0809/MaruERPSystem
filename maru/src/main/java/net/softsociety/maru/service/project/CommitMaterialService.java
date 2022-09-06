package net.softsociety.maru.service.project;

import java.util.ArrayList;

import net.softsociety.maru.domain.CommitMaterial;

public interface CommitMaterialService {

	int insertCommitMaterial(CommitMaterial commitMaterial);
	
	ArrayList<CommitMaterial> selectAllCommitMaterail();
	
	
}
