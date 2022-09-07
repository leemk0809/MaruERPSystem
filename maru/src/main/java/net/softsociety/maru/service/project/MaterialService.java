package net.softsociety.maru.service.project;

import java.util.List;
import java.util.Map;

import net.softsociety.maru.domain.Material;

public interface MaterialService {
	public List<Material> selectAll();
	public int insertMaterial(Material material);
	public int deleteMaterial(int material_num);
	/*
	 * Map<Integer, Integer>
	 *  첫번째 Integer(key) : material_num
	 *  두번째 Integer(value) : 원하는 수량
	 */
	public void addMaterial(Map<Integer, Integer> request);
	public void subtractMaterial(Map<Integer, Integer> request);
}
