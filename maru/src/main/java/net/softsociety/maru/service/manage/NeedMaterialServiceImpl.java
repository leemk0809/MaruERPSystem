package net.softsociety.maru.service.manage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.maru.dao.NeedMaterialDAO;
import net.softsociety.maru.domain.NeedMaterial;

@Service
public class NeedMaterialServiceImpl implements NeedMaterialService {

	@Autowired
	NeedMaterialDAO ndao;

	@Override
	public ArrayList<NeedMaterial> selectAll() {
		ArrayList<NeedMaterial> nList = ndao.selectAll();
		return nList;
	}

	@Override
	public int insert(NeedMaterial needMaterial) {
		int result = ndao.insert(needMaterial);
		return result;
	}

	@Override
	public int delete(int need_material_num) {
		int result = ndao.delete(need_material_num);
		return result;
	}

	@Override
	public int update(NeedMaterial needMaterial) {
		int result = ndao.update(needMaterial);
		return result;
	}

	@Override
	public NeedMaterial selectOne(int need_material_num) {
		NeedMaterial nm = ndao.selectOne(need_material_num);
		return nm;
	}

	@Override
	public List<NeedMaterial> thisNMList(int projects_num) {
		List<NeedMaterial> NMList = ndao.thisNMList(projects_num);
		return NMList;
	}

}
