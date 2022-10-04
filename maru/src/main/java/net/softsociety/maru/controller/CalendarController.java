package net.softsociety.maru.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.maru.domain.CommitMaterial;
import net.softsociety.maru.service.project.CommitMaterialService;

@Slf4j
@Controller
@Transactional
public class CalendarController {

	@Autowired
	CommitMaterialService commitMaterialService;
	
	@ResponseBody
	@GetMapping("getList")
	public ArrayList<CommitMaterial> cmlist(Model model) {
		
		ArrayList<CommitMaterial> commitMaterialList = (ArrayList<CommitMaterial>) commitMaterialService.selectAllCommitMaterial();

		
		
		return commitMaterialList;
	}
	
}
