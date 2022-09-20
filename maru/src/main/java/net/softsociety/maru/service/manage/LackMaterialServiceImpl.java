package net.softsociety.maru.service.manage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.dao.MaterialDAO;
import net.softsociety.maru.dao.NeedMaterialDAO;
import net.softsociety.maru.dao.ProjectsDAO;
import net.softsociety.maru.domain.LackMaterial;
import net.softsociety.maru.domain.Material;
import net.softsociety.maru.domain.NeedMaterial;
import net.softsociety.maru.domain.Projects;

@Service
@Slf4j
public class LackMaterialServiceImpl implements LackMaterialService {

	@Autowired
	NeedMaterialDAO nDAO;
	@Autowired
	MaterialDAO mDAO;
	@Autowired
	ProjectsDAO pDAO;
	
	List<LackMaterial> lackMaterialList = new ArrayList<>();
	
	@Override
	public List<LackMaterial> selectAllLackMaterial() {
		lackMaterialList = new ArrayList<>();
		List<Material> materialList = mDAO.selectAll(); 
		List<NeedMaterial> needMaterialList = nDAO.selectAll();
		
		for(NeedMaterial nm : needMaterialList) {
			for(Material m : materialList) {
				if(nm.getMaterial_num() == m.getMaterial_num()) {
					//전체 자재 - 필요 자재 < 0 ==> 부족
					if(m.getCount() - nm.getCount() < 0) {
						NeedMaterial newNM = nm;
						// 부족한 수 입력
						newNM.setCount(nm.getCount() - m.getCount());
						
						LackMaterial lackMaterial = new LackMaterial();
						lackMaterial.setMaterial_num(newNM.getMaterial_num());
						lackMaterial.setNeed_material_num(newNM.getNeed_material_num());
						lackMaterial.setCount(newNM.getCount());
						lackMaterial.setProject_num(newNM.getProjects_num());
						lackMaterial.setProject_name(pDAO.selectOne(newNM.getProjects_num()).getTitle());
						lackMaterial.setPrice(m.getPrice());
						lackMaterial.setMaterial_name(m.getMaterial_name());
						
						lackMaterial.setCommit_date(null);
						
						lackMaterialList.add(lackMaterial);
					}
				}
			}
		}
		initCommitDate();
		
		return lackMaterialList;
	}

	@Override
	public void initCommitDate() {
		List<Projects> pList = pDAO.selectAll();
		
		for(int i = 0 ; i < lackMaterialList.size(); i++) {
			for(Projects p : pList) {
				if(lackMaterialList.get(i).getProject_num() == p.getProjects_num()) {
					log.debug("p : {}", p);
					lackMaterialList.get(i).setCommit_date(p.getStart_date());
					continue;
				}
			}
		}
	}

	@Override
	public int deleteLackMaterial() {
		// 지워지면
		
		// material 증가
		
		return 0;
	}
	
	@Override
	public void addMaterial(Map<Integer, Integer> request) {
		List<Material> list = mDAO.selectAll();
		
		for(int key : request.keySet()) {
			int value = (int)request.get(key);
			
			for(Material m : list) {
				if(m.getMaterial_num() == key) {
					m.setCount(m.getCount() + value);
					log.debug("Material : {}", m);
					mDAO.update(m);
				}
			}
		}
	}
}
