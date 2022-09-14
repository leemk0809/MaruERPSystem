package net.softsociety.maru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.Material;
import net.softsociety.maru.service.manage.MaterialService;

@Slf4j
@Controller
@RequestMapping("/manage")
public class MaterialController {

	@Autowired
	MaterialService service;
	
	@GetMapping("/material")
	public String material(Model model) {
		List<Material> list = service.selectAll();
		
		log.debug("list : {} ", list);
		model.addAttribute("materialList", list);
		
		return "manage/material/material";
	}
}
