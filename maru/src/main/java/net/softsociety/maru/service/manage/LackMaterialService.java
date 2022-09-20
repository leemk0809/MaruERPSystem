package net.softsociety.maru.service.manage;

import java.util.List;
import java.util.Map;

import net.softsociety.maru.domain.LackMaterial;

public interface LackMaterialService {
	public List<LackMaterial> selectAllLackMaterial();
	public void initCommitDate();
	public int deleteLackMaterial();
	public void addMaterial(Map<Integer, Integer> request);
}
