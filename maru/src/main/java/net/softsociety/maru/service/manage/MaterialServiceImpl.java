package net.softsociety.maru.service.manage;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.dao.MaterialDAO;
import net.softsociety.maru.domain.Material;

@Service
@Slf4j
public class MaterialServiceImpl implements MaterialService {

	@Autowired
	MaterialDAO mdao;
	
	@Override
	public List<Material> selectAll() {
		return mdao.selectAll();
	}

	@Override
	public int insertMaterial(Material material) {
		return mdao.insert(material);
	}

	@Override
	public int deleteMaterial(int material_num) {
		return mdao.delete(material_num);
	}

	@Override
	public void addMaterial(Map<Integer, Integer> request) {
		List<Material> list = mdao.selectAll();
		
		for(int key : request.keySet()) {
			int value = (int)request.get(key);
			
			for(Material m : list) {
				if(m.getMaterial_num() == key) {
					m.setCount(m.getCount() + value);
					log.debug("Material : {}", m);
					mdao.update(m);
				}
			}
		}
	}

	@Override
	public void subtractMaterial(Map<Integer, Integer> request) {
		List<Material> list = mdao.selectAll();
		
		for(int key : request.keySet()) {
			int value = (int)request.get(key);
			
			for(Material m : list) {
				if(m.getMaterial_num() == key) {
					m.setCount(m.getCount() - value);
					log.debug("Material : {}", m);
					mdao.update(m);
				}
			}
		}
	}

}
