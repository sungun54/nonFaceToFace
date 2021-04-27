package com.nftf.kys.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrAdmHomeController {

	@ResponseBody
	@RequestMapping("/adm/home/main")
	public String showMain() {
		return "안녕하세요";
	}

}
