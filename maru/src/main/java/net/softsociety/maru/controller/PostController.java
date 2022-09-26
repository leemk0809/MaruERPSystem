package net.softsociety.maru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		
		return "dashboard/post";
	}
	
	@GetMapping("deletePost")
	public String deletePost(int post_num) {
		
		int result = postService.deletePost(post_num);
		log.debug("삭제 여부:{}",result);
		
		return "redirect:/dashboard/post";
	}
	
	@GetMapping("insertProject")
	public String insertProject(Model model, int post_num) {
		int result = 0;
		
		Post post = postService.selectOne(post_num);
		
		Projects project = new Projects();
		
		List<Projects> plist = proService.selectAllProjects();
		
		for(Projects projects : plist) {
			if(projects.getPost_num() != post_num) {
				result = 1;
				project.setTitle(post.getTitle());
				project.setStatus("진행전");
				project.setPost_num(post_num);
				
				proService.insertProject(projects);
			}
		}
		
		model.addAttribute("result",result);
		
		
		
		return "redirect:/dashboard/post";
	}
}
