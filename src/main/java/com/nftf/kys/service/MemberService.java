package com.nftf.kys.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nftf.kys.dto.Member;
import com.nftf.kys.dto.ResultData;
import com.nftf.kys.mapper.MemberMapper;
import com.nftf.kys.util.Util;

@Service
public class MemberService {
	
	@Autowired MemberMapper memberMapper;
	
	public ResultData join(Map<String, Object> param) {
		memberMapper.join(param);
		
		int id = Util.getAsInt(param.get("id"), 0);
		
		return new ResultData("S-1", String.format("%s님 환영합니다", param.get("nickname")), "id", id);
	}

	public Member getMember(String loginId) {
		return memberMapper.getMemberByLoginId(loginId);
	}

}