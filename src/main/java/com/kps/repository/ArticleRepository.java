package com.kps.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.kps.model.Article;

@Repository
public interface ArticleRepository {

	@Select("SELECT id, title, description, author, thumbnail FROM tbarticle")
	/*@Results({
		@Result(property="id", column="id"),
		@Result(property="title", column="title"),
		@Result(property="description", column="description"),
		@Result(property="author", column="author"),
		@Result(property="thumbnail", column="thumbnail"),
	})*/
	List<Article> findAll();

	@Select("SELECT id, title, description, author, thumbnail FROM tbarticle WHERE id=#{id}")
	Article findOne(int id);

	@Insert("INSERT INTO tbarticle(title, description, author, thumbnail) VALUES(#{title}, #{description}, #{author}, #{thumbnail})")
	boolean save(Article article);

	@Delete("DELETE FROM tbarticle WHERE id=#{id}")
	boolean remove(int id);
	
	@Update("UPDATE tbarticle SET title=#{title}, description=#{description}, author=#{author}, thumbnail=#{thumbnail} WHERE id=#{id}")
	boolean update(Article article);
}








