package net.softsociety.maru.service.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.softsociety.maru.dao.MaterialDAO;
import net.softsociety.maru.dao.NeedMaterialDAO;
import net.softsociety.maru.dao.PostDAO;
import net.softsociety.maru.dao.ProjectsDAO;
import net.softsociety.maru.dao.ProjectsTagDAO;
import net.softsociety.maru.dao.WorkerDAO;
import net.softsociety.maru.domain.Material;
import net.softsociety.maru.domain.NeedMaterial;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.domain.ProjectsTag;
import net.softsociety.maru.domain.Worker;

@Service
public class InsertProjectServiceImpl implements InsertProjectService {

	@Autowired
	ProjectsDAO projectsDAO;
	@Autowired
	PostDAO postDAO;
	@Autowired
	NeedMaterialDAO nmDAO;
	@Autowired
	MaterialDAO mDAO;
	@Autowired
	WorkerDAO wDAO;
	@Autowired
	ProjectsTagDAO ptDAO;
	
	
	@Override
	public void updateProject(Projects project) {
		projectsDAO.update(project);
	}

	@Override
	public List<Projects> selectProjectByStatusBefore() {
		List<Projects> projectList = projectsDAO.selectAll();
		List<Projects> resultList = new ArrayList<>();
		
		for(Projects p : projectList) {
			if(p.getStatus().equals("진행전")) {
				resultList.add(p);
			}
		}
		
		return resultList;
	}

	@Override
	public List<Material> selectAllMaterial() {
		return mDAO.selectAll();
	}

	@Override
	public int averageSalry() {
		List<Worker> workerList = wDAO.selectAll();
		int averageSalry;
		int totalSalary = 0;
		
		for(Worker w : workerList) {
			totalSalary += w.getSalary();
		}
		
		averageSalry = totalSalary / workerList.size();
		
		return averageSalry;
	}

	@Override
	public int calcNeedMaterialPrice(int project_num) {
		List<NeedMaterial> needMaterialList = nmDAO.selectAll();
		List<Material> materialList = mDAO.selectAll();
		int total = 0;
		
		for(NeedMaterial nm : needMaterialList) {
			if(nm.getProjects_num() == project_num) {
				for(Material m : materialList) {
					if(nm.getMaterial_num() == m.getMaterial_num()) {
						total += nm.getCount() * m.getPrice();
					}
				}
			}
		}
		return total;
	}
	
	
	
	@Override
	public void insertNeedMaterial(int project_num, int material_num, int count) {
		nmDAO.insert(new NeedMaterial(0, project_num, material_num, count));	
	}

	@Override
	public int calcPredictPrice(int project_num) {		
		return averageSalry() + calcNeedMaterialPrice(project_num);
	}

	@Override
	public void insertProjectTag(List<Integer> positionNumList, int projects_num) {
		for(Integer p : positionNumList) {
			ptDAO.insert(new ProjectsTag(0, p, projects_num, "N"));
		}
	}
}
