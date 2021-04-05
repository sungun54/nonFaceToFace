package com.nftf.kys.dto;

import lombok.Data;

@Data
public class Article {
	private int id;
	private String regDate;
	private String title;
	private String body;
	
	public Article(int id, String regDate, String title, String body) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.body = body;
	}
}
