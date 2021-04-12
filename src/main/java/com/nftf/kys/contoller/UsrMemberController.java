package com.nftf.kys.contoller;

import java.util.Map;

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

}
