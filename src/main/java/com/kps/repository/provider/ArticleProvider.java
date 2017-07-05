package com.kps.repository.provider;

import org.apache.ibatis.jdbc.SQL;

import com.kps.model.Article;
import com.kps.model.filter.ArticleFilter;

public class ArticleProvider {
	
	public String findAll(){
		return new SQL(){{
			SELECT("A.id, A.title, A.description, A.thumbnail");
			SELECT("C.id AS \"categoryId\", C.name");
			FROM("tbarticle A");
			INNER_JOIN("tbcategory C ON C.id=A.category_id");
			ORDER_BY("id ASC");
		}}.toString();
	};
	
	public String save(Article article){
		return new SQL(){{
			INSERT_INTO("tbarticle")
			.VALUES("title", "#{title}")
			.VALUES("description", "#{description}")
			.VALUES("thumbnail", "#{thumbnail}");
		}}.toString();
	};
	
	
	public String findByFilter(ArticleFilter filter){
		return new SQL(){{
			SELECT("A.id, A.title, A.description, A.thumbnail");
			SELECT("C.id AS \"categoryId\", C.name");
			FROM("tbarticle A");
			INNER_JOIN("tbcategory C ON C.id=A.category_id");
			
			if(filter.getCategoryId()!=null)
				WHERE("A.category_id=#{categoryId}");
			
			if(filter.getTitle()!=null)
				WHERE("A.title ILIKE '%' || #{title} || '%'");
			
			ORDER_BY("id ASC");
		}}.toString();
	}	
}
