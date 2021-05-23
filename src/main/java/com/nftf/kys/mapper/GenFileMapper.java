package com.nftf.kys.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.nftf.kys.dto.GenFile;

@Mapper
public interface GenFileMapper {
	void saveMeta(Map<String, Object> param);
	GenFile getGenFile(String relTypeCode, int relId, String typeCode, String type2Code, int fileNo);
}