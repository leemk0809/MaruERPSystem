package net.softsociety.maru.service.manage;

import java.util.List;
import java.util.Map;

import net.softsociety.maru.domain.NeedMaterial;

public interface LackMaterialService {
	public List<NeedMaterial> selectAllLackMaterial();
	public List<String> selectAllCommitDate();
	public int deleteLackMaterial();
	public void addMaterial(Map<Integer, Integer> request);
}
