package com.kps.service;

import java.util.List;

import com.kps.model.Article;

public interface ArticleService {
	
	List<Article> findAll();

	Article findOne(int id);

	boolean save(Article article);

	boolean remove(int id);
}
