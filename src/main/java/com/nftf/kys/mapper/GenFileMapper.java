package com.nftf.kys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nftf.kys.dto.GenFile;

@Mapper
public interface GenFileMapper {
	void saveMeta(Map<String, Object> param);

	GenFile getGenFile(@Param("relTypeCode") String relTypeCode, @Param("relId") int relId,
			@Param("typeCode") String typeCode, @Param("type2Code") String type2Code, @Param("fileNo") int fileNo);

	void changeRelId(@Param("id") int id, @Param("relId") int relId);

	void deleteFiles(@Param("relTypeCode") String relTypeCode, @Param("relId") int relId);

	List<GenFile> getGenFiles(@Param("relTypeCode") String relTypeCode, @Param("relId") int relId,
			@Param("typeCode") String typeCode, @Param("type2Code") String type2Code);

	void deleteFile(@Param("id") int id);
}