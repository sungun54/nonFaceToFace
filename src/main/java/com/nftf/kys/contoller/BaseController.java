package com.nftf.kys.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
	protected String msgAndBack(HttpServletRequest req, String msg) {
		req.setAttribute("historyBack", true);
		req.setAttribute("msg", msg);
		return "common/redirect";
	}

	protected String msgAndReplace(HttpServletRequest req, String msg, String redirectUrl) {
		req.setAttribute("redirectUrl", redirectUrl);
		req.setAttribute("msg", msg);
		return "common/redirect";
	}
}