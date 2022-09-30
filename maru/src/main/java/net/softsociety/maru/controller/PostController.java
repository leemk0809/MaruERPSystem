package net.softsociety.maru.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Post;
import net.softsociety.maru.domain.Projects;
import net.softsociety.maru.service.dashboard.PostService;
import net.softsociety.maru.service.project.ProjectInfoService;

@Controller
@Slf4j
@RequestMapping("/dashboard")
public class PostController {

	@Autowired
	PostService postService;
	
	@Autowired
	ProjectInfoService proService;
	
	@GetMapping("/post")
	public String post(Model model) {
		List<Post> postList = postService.selectAllPost();
		log.debug("공고목록:{}",postList);
		
		model.addAttribute("postList",postList);
		
		List<Projects> projectsList = proService.selectAllProjects();
		log.debug("프로젝트 목록:{}",projectsList);
		
		model.addAttribute("pList",projectsList);
		
		List<Projects> limitList = new ArrayList<Projects>(); 
		
		for(Projects pro : projectsList) {
			if(pro.getStatus().equals("결재전")){
				limitList.add(pro);
			}
		}
		log.debug("결재전 프로젝트:{}",limitList);
		log.debug("결재전 프로젝트 갯수:{}",limitList.size());
		
		model.addAttribute("limitList",limitList);
		model.addAttribute("limitsize",limitList.size());
		
		
		return "dashboard/post";
	}
	
	@GetMapping("deletePost")
	public String deletePost(int post_num) {
		
		int result = postService.deletePost(post_num);
		log.debug("삭제 여부:{}",result);
		
		return "redirect:/dashboard/post";
	}
	
	@ResponseBody
	@GetMapping("insertProject")
	public int insertProject(Model model, int post_num) {		
		int result = 0;
		log.debug("넘어온포스트넘:{}",post_num);
		
		Post post = postService.selectOne(post_num);
		
		Projects project = new Projects();
		
		List<Projects> plist = proService.selectAllProjects();
				
		for(Projects projects : plist) {
			if(projects.getPost_num() == post_num) {
				result +=1;				
			}
		}		
		if(result == 0) {
			project.setTitle(post.getTitle());
			project.setStatus("결재전");
			project.setPost_num(post_num);
			project.setStart_date("2022-10-03");
			project.setEnd_date("2022-10-10");
			project.setNeed_worker(10);
			project.setAmount(2000);
			project.setBlueprint_path("	");
			project.setAirview_path("미정");
			
			proService.insertProject(project);
		}	
		
		log.debug("결과값:{}",result);
		model.addAttribute("result",result);
		
		return result;
	}
}
