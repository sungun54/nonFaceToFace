package com.nftf.kys.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	void join(Map<String, Object> param);
}
