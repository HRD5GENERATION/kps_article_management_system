package com.kps.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.kps.model.Article;
import com.kps.model.filter.ArticleFilter;
import com.kps.repository.provider.ArticleProvider;

@Repository
public interface ArticleRepository {

	@SelectProvider(method="findAll", type=ArticleProvider.class)
	@Results({
		@Result(property="category.id", column="categoryId"),
		@Result(property="category.name", column="name"),
	})
	List<Article> findAll();

	@Select("SELECT id, title, description, thumbnail FROM tbarticle WHERE id=#{id}")
	Article findOne(int id);

	@InsertProvider(method="save", type=ArticleProvider.class)
	boolean save(Article article);

	@Delete("DELETE FROM tbarticle WHERE id=#{id}")
	boolean remove(int id);
	
	@Update("UPDATE tbarticle SET title=#{title}, description=#{description}, thumbnail=#{thumbnail} WHERE id=#{id}")
	boolean update(Article article);
	
	@SelectProvider(method="findByFilter", type=ArticleProvider.class)
	List<Article> findByFilter(ArticleFilter filter);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}








