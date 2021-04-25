package com.nftf.kys.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nftf.kys.dto.Article;
import com.nftf.kys.dto.Board;
import com.nftf.kys.dto.ResultData;
import com.nftf.kys.mapper.ArticleMapper;
import com.nftf.kys.mapper.BoardMapper;
import com.nftf.kys.mapper.ReplyMapper;
import com.nftf.kys.util.Util;

@Service
public class ArticleService {
	@Autowired
	private ArticleMapper articleMapper;

	@Autowired
	private BoardMapper boardMapper;

	@Autowired
	private ReplyMapper replyMapper;
	
	@Autowired
	private MemberService memberService;

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

	public ResultData getActorCanModify(Article article, int actorId) {
		if (article.getMemberId() == actorId) {
			return new ResultData("S-1", "가능합니다.");
		}

		if (memberService.isAdmin(actorId)) {
			return new ResultData("S-2", "가능합니다.");
		}

		return new ResultData("F-1", "권한이 없습니다.");
	}

	public ResultData getActorCanDelete(Article article, int actorId) {
		return getActorCanModify(article, actorId);
	}

	public Article getForPrintArticle(int id) {
		return articleMapper.getForPrintArticle(id);
	}

	public List<Article> getForPrintArticles(int boardId, String searchKeywordType, String searchKeyword, int page,
			int itemsInAPage) {
		int limitStart = (page - 1) * itemsInAPage;
		int limitTake = itemsInAPage;

		return articleMapper.getForPrintArticles(boardId, searchKeywordType, searchKeyword, limitStart, limitTake);
	}

	public Board getBoard(int id) {
		return boardMapper.getBoard(id);
	}

	public ResultData addReply(Map<String, Object> param) {
		replyMapper.addReply(param);

		int id = Util.getAsInt(param.get("id"), 0);

		return new ResultData("S-1", "성공하였습니다.", "id", id);
	}
}