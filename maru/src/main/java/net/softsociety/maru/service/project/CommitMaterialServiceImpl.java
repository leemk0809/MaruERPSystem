package net.softsociety.maru.service.project;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.dao.CommitMaterialDAO;
import net.softsociety.maru.domain.CommitMaterial;

@Service
@Transactional
@Slf4j
public class CommitMaterialServiceImpl implements CommitMaterialService {

	@Autowired
	CommitMaterialDAO commitMaterialDAO;

	@Override
	public int insertCommitMaterial(CommitMaterial commitMaterial) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<CommitMaterial> selectAllCommitMaterail() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
