package com.nftf.kys.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nftf.kys.dto.ResultData;
import com.nftf.kys.mapper.GenFileMapper;
import com.nftf.kys.util.Util;

@Service
public class GenFileService {
	@Autowired
	private GenFileMapper genFileMapper;

	public ResultData saveMeta(String relTypeCode, int relId, String typeCode, String type2Code, int fileNo,
			String originFileName, String fileExtTypeCode, String fileExtType2Code, String fileExt, int fileSize,
			String fileDir) {

		Map<String, Object> param = Util.mapOf("relTypeCode", relTypeCode, "relId", relId, "typeCode", typeCode,
				"type2Code", type2Code, "fileNo", fileNo, "originFileName", originFileName, "fileExtTypeCode",
				fileExtTypeCode, "fileExtType2Code", fileExtType2Code, "fileExt", fileExt, "fileSize", fileSize,
				"fileDir", fileDir);
		genFileMapper.saveMeta(param);

		int id = Util.getAsInt(param.get("id"), 0);
		return new ResultData("S-1", "성공하였습니다.", "id", id);
	}

}