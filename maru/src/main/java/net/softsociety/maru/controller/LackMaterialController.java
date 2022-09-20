package net.softsociety.maru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.LackMaterial;
import net.softsociety.maru.service.manage.LackMaterialService;

@Slf4j
@Controller
@RequestMapping("/manage")
public class LackMaterialController {
	
	@Autowired
	LackMaterialService service;
	
	@GetMapping("/lackMaterial")
	public String lackMaterial() {
		return "manage/material/lackMaterial";
	}
	
	@ResponseBody
	@PostMapping("/printByMaterialnum")
	public List<LackMaterial> printByMaterialnum(){
		return service.selectAllLackMaterial();
	}
}
