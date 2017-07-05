package com.kps.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kps.model.Article;
import com.kps.model.filter.ArticleFilter;
import com.kps.repository.ArticleRepository;

@RestController
public class ArticleRestController {

	@Autowired
	private ArticleRepository aRepo;
	
	//localhost:8080/article/rest?title=tt&categoryId=1
	@GetMapping("/article/rest")
	public List<Article> findByFilter(ArticleFilter filter){
		System.out.println(filter);
		return aRepo.findByFilter(filter);
	}
	
}
