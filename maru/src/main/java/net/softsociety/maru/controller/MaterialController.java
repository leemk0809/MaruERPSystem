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
	
	@ResponseBody
	@PostMapping("/printmaterial")
	public List<Material> printmaterial() {
		return service.selectAll();
	}
	
	@ResponseBody
	@PostMapping("/printByName")
	public List<Material> printByName() {
		return service.selectAllByName();
	}
	
	@ResponseBody
	@PostMapping("/printByPrice")
	public List<Material> printByPrice() {
		return service.selectAllByPrice();
	}
	
	@ResponseBody
	@PostMapping("/printByCount")
	public List<Material> printByCount() {
		return service.selectAllByCount();
	}
	
	
	@ResponseBody
	@PostMapping("/insertMaterial")
	public List<Material> insertMaterial(Material material){
		log.debug("material : {}", material);
		service.insertMaterial(material);
		
		return service.selectAll();
	}
	
	@ResponseBody
	@PostMapping("/deleteMaterial")
	public void deleteMaterial(int num) {
		log.debug("num : {}", num);
		service.deleteMaterial(num);
	}
	
	
}
