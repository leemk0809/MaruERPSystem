package net.softsociety.maru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Division;
import net.softsociety.maru.domain.Position;
import net.softsociety.maru.domain.Worker;
import net.softsociety.maru.service.manage.WorkerService;

@Slf4j
@Controller
@RequestMapping("/manage")
public class WorkerController {
	
	@Autowired
	WorkerService service;
	
	@GetMapping("/worker")
	public String worker(Model model) {
		
		List<Worker> Wlist = service.selectAll();		
		model.addAttribute("workerList",Wlist);		
		List<Division> Dlist = service.divisionList();
		model.addAttribute("divisionList",Dlist);		
		List<Position> Plist = service.positionList();
		model.addAttribute("positionList",Plist);
		
		return"/manage/worker";
	}
	
	@ResponseBody
	@GetMapping("/deleteWorker")
	public void deleteWorker(int num) {
		//이거 cascade 때문에 삭제 안됨. 테이블 엎어야됨
		//service.deleteWorker(num);
	}
	
	
	@ResponseBody
	@PostMapping("/insertWorker")
	public List<Worker> insertWorker(Worker worker){
		log.debug("worker : {}",worker);
		service.insertWorker(worker);
		
		
		return service.selectAll();
	}
	
	
	
	
}
