package com.nftf.kys.contoller;

import java.net.http.HttpRequest;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nftf.kys.dto.Member;
import com.nftf.kys.dto.ResultData;
import com.nftf.kys.service.MemberService;

@Controller
public class UsrMemberController {

	@Autowired
	private  MemberService memberService;

	@ResponseBody
	@RequestMapping("/usr/member/doJoin")
	public ResultData doJoin(@RequestParam Map<String, Object> param) {
		if (param.get("loginId") == null) {
			return new ResultData("F-1", "loginId을 입력해주세요.");			
		}
		
		Member existingMemmember = memberService.getMember((String)param.get("loginId"));
		
		if (existingMemmember != null) {
			return new ResultData("F-2", String.format("%s (은)는 이미 사용중인 로그인아이디 입니다.", param.get("loginId")));
		}
		
		if (param.get("loginPw") == null) {
			return new ResultData("F-1", "loginPw을 입력해주세요.");
		}

		if (param.get("name") == null) {
			return new ResultData("F-1", "name을 입력해주세요.");
		}
		
		if (param.get("nickname") == null) {
			return new ResultData("F-1", "nickname을 입력해주세요.");
		}
		
		if (param.get("cellphoneNo") == null) {
			return new ResultData("F-1", "cellphoneNo을 입력해주세요.");
		}
		
		if (param.get("email") == null) {
			return new ResultData("F-1", "email을 입력해주세요.");
		}


		return memberService.join(param);
	}
	
	@ResponseBody
	@RequestMapping("/usr/member/doLogin")
	public ResultData doLogin(String loginId, String loginPw, HttpSession session) {
		
		if(session.getAttribute("loginedMemberId") != null) {
			return new ResultData("F-4", "이미 로그인되어있는 아이디입니다.");
		}
		
		if (loginId == null) {
			return new ResultData("F-1", "loginId을 입력해주세요.");			
		}
		
		Member existingMemmember = memberService.getMember(loginId);
		
		if (existingMemmember != null) {
			return new ResultData("F-2", "존재하지않는 아이디입니다.", "loginId", loginId);
		}
		
		if (loginPw == null) {
			return new ResultData("F-1", "loginPw을 입력해주세요.");
		}	
		
		if (existingMemmember.getLoginPw().equals(loginPw) == false) {
			return new ResultData("F-3", "비밀번호가 일치하지 않습니다.");
		}
		
		session.setAttribute("loginedMemberId", existingMemmember.getId());

		return new ResultData("S-1", String.format("%s님 환영합니다.", existingMemmember.getNickname()));
	}
}
