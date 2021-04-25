package com.nftf.kys.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nftf.kys.dto.Board;

@Mapper
public interface BoardMapper {
	Board getBoard(@Param("id") int id);
}
