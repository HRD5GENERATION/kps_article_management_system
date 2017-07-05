package com.kps.repository;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.kps.model.Article;
import com.kps.model.Category;

@Repository
public interface CategoryRepository {

	@Select("SELECT * FROM tbcategory")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="name", column="name")
	})
	List<Category> findAll();
	
	
	@Select("SELECT * FROM tbcategory")
	@Results({
		@Result(property="id", column="id"),
		@Result(property="name", column="name"),
		@Result(property="articles", column="id", many=@Many(select="com.kps.repository.CategoryRepository.findArticleByCategoryId"))
	})
	List<Category> findAllCategoryWithArticle();
	
	@Select("SELECT * FROM tbarticle WHERE category_id=#{id}")
	public List<Article> findArticleByCategoryId(Integer id);
}
