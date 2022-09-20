package net.softsociety.maru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
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
		
		List<Worker> list = service.selectAll();
		
		model.addAttribute("workerList",list);
		
		return"/manage/worker";
	}
}
