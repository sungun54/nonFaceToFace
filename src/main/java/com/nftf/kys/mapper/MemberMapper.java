package com.nftf.kys.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nftf.kys.dto.Member;

@Mapper
public interface MemberMapper {
	void join(Map<String, Object> param);
	Member getMember(@Param("id") int id);
	public Member getMemberByLoginId(@Param("loginId") String loginId);
}