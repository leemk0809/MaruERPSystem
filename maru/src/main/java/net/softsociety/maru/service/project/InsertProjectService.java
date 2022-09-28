package net.softsociety.maru.service.project;

import java.util.List;

import net.softsociety.maru.domain.Material;
import net.softsociety.maru.domain.Projects;

public interface InsertProjectService {
	public void updateProject(Projects project);
	public List<Projects> selectProjectByStatusBefore();
	public List<Material> selectAllMaterial();
	public int averageSalry();
	public int calcPredictPrice(int project_num);
	public int calcNeedMaterialPrice(int project_num);
	public void insertNeedMaterial(int project_num, int material_num, int count);
	
	public void insertProjectTag(List<Integer> positionNumList, int projects_num);
	
}
