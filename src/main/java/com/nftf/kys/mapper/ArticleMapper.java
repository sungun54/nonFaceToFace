package com.nftf.kys.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nftf.kys.dto.Article;

@Mapper
public interface ArticleMapper {
	public Article getArticle(@Param("id") int id);

	public void addArticle(Map<String, Object> param);

	public void deleteArticle(@Param("id") int id);

	public void modifyArticle(@Param("id") int id, @Param("title") String title,
			@Param("body") String body);

	public List<Article> getArticles(@Param("searchKeywordType") String searchKeywordType,
			@Param(value = "searchKeyword") String searchKeyword);

	public Article getForPrintArticle(@Param("id") int id);

	public List<Article> getForPrintArticles(@Param("searchKeywordType") String searchKeywordType, @Param(value = "searchKeyword") String searchKeyword, @Param("limitStart") int limitStart, @Param("limitTake") int limitTake);
}
