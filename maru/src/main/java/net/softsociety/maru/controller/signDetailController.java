package net.softsociety.maru.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class signDetailController {

	@GetMapping("dashboard/signDetail")
	public String signDetail() {
		return "dashboard/signDetail.html";
	}

}
