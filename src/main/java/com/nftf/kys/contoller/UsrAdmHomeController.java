package com.nftf.kys.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsrAdmHomeController {

	@RequestMapping("/adm/home/main")
	public String showMain() {
		return "adm/home/main";
	}

}
