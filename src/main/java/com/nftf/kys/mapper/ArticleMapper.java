package com.nftf.kys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nftf.kys.dto.Article;

@Mapper
public interface ArticleMapper {
	Article getArticle(@Param("id") int id);

	void addArticle(Map<String, Object> param);

	void deleteArticle(@Param("id") int id);

	void modifyArticle(Map<String, Object> param);

	List<Article> getArticles(@Param("searchKeywordType") String searchKeywordType,
			@Param(value = "searchKeyword") String searchKeyword);

	Article getForPrintArticle(@Param("id") int id);

	List<Article> getForPrintArticles(@Param("boardId") int boardId,
			@Param("searchKeywordType") String searchKeywordType, @Param("searchKeyword") String searchKeyword,
			@Param("limitStart") int limitStart, @Param("limitTake") int limitTake);

}
