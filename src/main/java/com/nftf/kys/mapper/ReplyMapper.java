package com.nftf.kys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nftf.kys.dto.Reply;

@Mapper
public interface ReplyMapper {
	void addReply(Map<String, Object> param);

	List<Reply> getForPrintReplies(@Param("relTypeCode") String relTypeCode, @Param("relId") int relId);

	Reply getReply(@Param("id") int id);
	
	void deleteReply(@Param("id") int id);

	void modifyReply(@Param("id") int id, @Param("body") String body);
}
