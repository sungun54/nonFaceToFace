package com.nftf.kys.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nftf.kys.dto.Article;
import com.nftf.kys.dto.ResultData;
import com.nftf.kys.mapper.ArticleMapper;
import com.nftf.kys.util.Util;

@Service
public class ArticleService {
	@Autowired
	private ArticleMapper articleMapper;

	public Article getArticle(int id) {
		return articleMapper.getArticle(id);
	}

	public ResultData addArticle(Map<String, Object> param) {
		articleMapper.addArticle(param);

		int id = Util.getAsInt(param.get("id"), 0);

		return new ResultData("S-1", "성공하였습니다.", "id", id);
	}

	public ResultData deleteArticle(int id) {
		articleMapper.deleteArticle(id);

		return new ResultData("S-1", "삭제하였습니다.", "id", id);
	}

	public ResultData modifyArticle(int id, String title, String body) {
		articleMapper.modifyArticle(id, title, body);

		return new ResultData("S-1", "게시물을 수정하였습니다.", "id", id);
	}

	public List<Article> getArticles(String searchKeywordType, String searchKeyword) {
		return articleMapper.getArticles(searchKeywordType, searchKeyword);
	}
}