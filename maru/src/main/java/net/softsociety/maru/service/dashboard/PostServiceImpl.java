package net.softsociety.maru.service.dashboard;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.dao.BuildingTypeDAO;
import net.softsociety.maru.dao.PostDAO;
import net.softsociety.maru.dao.ProjectsDAO;
import net.softsociety.maru.domain.BuildingType;
import net.softsociety.maru.domain.Post;
import net.softsociety.maru.domain.Projects;

@Service
@Transactional
@Slf4j
public class PostServiceImpl implements PostService {

	@Autowired
	PostDAO postDAO;

	@Autowired
	ProjectsDAO projectsDAO;
	
	@Autowired
	BuildingTypeDAO btDAO;
	/**
	 * 공고 전체 목록 출력하여 보여주기
	 */
	@Override
	public ArrayList<Post> selectAllPost() {

		ArrayList<Post> postList = postDAO.selectAll();
		
		return postList;
	}

	/**
	 * post에서 가져온 공고정보를 바탕으로 프로젝트 추가함
	 * controller에서 post정보가져와서 status및 정보 추가후 프로젝트테이블에 insert
	 */
	@Override
	public int insertProjects(Projects projects) {

		int result = projectsDAO.insert(projects);
		
		return result;
	}

	@Override
	public String buildingTypeName(int num) {

		BuildingType buildingType = btDAO.selectOne(num);
		
		String result = buildingType.getBuilding_type_name();
		
		return result;
	}

	@Override
	public int deletePost(int post_num) {

		int result = postDAO.delete(post_num);
		
		return result;
	}

	@Override
	public Post selectOne(int post_num) {
		Post post = postDAO.selectOne(post_num);
		return post;
	}
	
	
}
