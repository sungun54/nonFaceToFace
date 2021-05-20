package com.nftf.kys.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GenFileMapper {
	void saveMeta(Map<String, Object> param);
}