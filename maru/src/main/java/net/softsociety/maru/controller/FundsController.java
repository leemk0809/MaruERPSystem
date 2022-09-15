package net.softsociety.maru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class FundsController {

	@GetMapping("/funds")
	public String index() {
		return "manage/funds";
	}
}
