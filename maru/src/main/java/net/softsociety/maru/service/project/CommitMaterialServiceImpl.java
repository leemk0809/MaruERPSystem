package net.softsociety.maru.service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.dao.CommitMaterialDAO;
import net.softsociety.maru.dao.NeedMaterialDAO;
import net.softsociety.maru.domain.CommitMaterial;
import net.softsociety.maru.domain.NeedMaterial;

@Service
@Transactional
@Slf4j
public class CommitMaterialServiceImpl implements CommitMaterialService {

	@Autowired
	CommitMaterialDAO commitMaterialDAO;
	
	@Autowired
	NeedMaterialDAO needMaterialDAO;
	
	@Override
	public int insertCommitMaterial(CommitMaterial commitMaterial) {
		
		int result = commitMaterialDAO.insert(commitMaterial);
		
		return result;
	}

	@Override
	public List<CommitMaterial> selectAllCommitMaterial() {

		List<CommitMaterial> commitMaterialList = commitMaterialDAO.selectAll();
		
		return commitMaterialList;
	}

	
	
	@Override
	public int deleteCommitMaterial(int commitMaterial_num) {

		int result = commitMaterialDAO.delete(commitMaterial_num);
		
		return result;
	}

	@Override
	public CommitMaterial selectOne(int commitMaterial_num) {

		CommitMaterial commitMaterial = commitMaterialDAO.selectOne(commitMaterial_num);
		
		return commitMaterial;
	}

	@Override
	public List<CommitMaterial> selectCommitMaterialByCategory(String category) {

		//category 추가 후 생성하자 
		List<CommitMaterial> list = commitMaterialDAO.selectAll();
		
		return list;
	}

	@Override
	public List<CommitMaterial> thisCommitMaterialList(int projects_num) {

		List<CommitMaterial> thisCommitMaterialList = commitMaterialDAO.thisList(projects_num);
		
		return thisCommitMaterialList;
	}

	@Override
	public List<NeedMaterial> thisNeedMaterialList(int projects_num) {

		List<NeedMaterial> thisNeedMaterialList = needMaterialDAO.thisNMList(projects_num);
		
		return thisNeedMaterialList;
	}
	
	
}
