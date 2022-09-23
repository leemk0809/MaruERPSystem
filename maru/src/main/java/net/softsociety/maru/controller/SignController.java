package net.softsociety.maru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/dashboard")
public class SignController {
	
	@GetMapping("/sign")
	public String sign(Model model) {
		
		return "/dashboard/sign";
	}

}
