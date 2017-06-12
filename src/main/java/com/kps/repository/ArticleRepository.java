package com.kps.repository;

import java.util.List;

import com.kps.model.Article;

public interface ArticleRepository {

	List<Article> findAll();

	Article findOne(int id);

	boolean save(Article article);

	boolean remove(int id);

}
