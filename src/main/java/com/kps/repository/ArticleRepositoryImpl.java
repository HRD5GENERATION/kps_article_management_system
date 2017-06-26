/*package com.kps.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;
import com.kps.model.Article;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository{
	
	private List<Article> articles;
	
	public ArticleRepositoryImpl() {
		Faker faker = new Faker(Locale.ENGLISH);
		articles = new ArrayList<>();
		
		for(int i=0; i<20; i++){
			Article article = new Article();
			article.setId(i+1);
			article.setTitle(faker.book().title());
			article.setAuthor(faker.book().author());
			article.setDescription(faker.lorem().sentence());
			article.setThumbnail(faker.internet().image(100, 100, false, null));
			articles.add(article);
		}
	}
	
	@Override
	public List<Article> findAll() {
		return articles;
	}

	@Override
	public Article findOne(int id) {
		for(Article article: articles){
			if(article.getId() == id)
				return article;
		}
		return null;
	}

	@Override
	public boolean save(Article article) {
		return articles.add(article);
	}

	@Override
	public boolean remove(int id) {
		for(Article article: articles){
			if(article.getId() == id){
				articles.remove(article);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean update(Article article) {
		for(int i=0; i<articles.size(); i++){
			if(article.getId() == articles.get(i).getId()){
				articles.set(i, article);
				return true;
			}
		}
		return false;
	}

}
*/