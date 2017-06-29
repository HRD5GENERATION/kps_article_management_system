package com.kps.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kps.model.Article;
import com.kps.service.ArticleService;
import com.kps.service.upload.UploadService;

@Controller
public class ArticleController {
	
	private ArticleService articleService;
	
	@Autowired
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@RequestMapping(value="/article", method= RequestMethod.GET)
	public String homePage(ModelMap model){
		List<Article> articles = articleService.findAll();
		model.addAttribute("articles", articles);
		return "article";
	}

	/*@GetMapping("/article/view")
	public String detailPage(ModelMap model, @RequestParam("id") Integer id){
		Article article = articleService.findOne(id);
		model.addAttribute("article", article);
		return "articledetail";
	}*/
	
	@GetMapping("/article/view/{id}")
	public String detailPage1(ModelMap model, @PathVariable("id") Integer id){
		Article article = articleService.findOne(id);
		model.addAttribute("article", article);
		return "articledetail";
	}
	
	@GetMapping("/article/remove/{id}")
	public String removePage(ModelMap model, @PathVariable("id") Integer id){
		if(articleService.remove(id))
			System.out.println("success!");
		else
			System.out.println("failed!");
		
		return "redirect:/article";
	}
	
	@GetMapping("/article/add")
	public String saveArticlePage(ModelMap model){
		model.addAttribute("article", new Article());
		model.addAttribute("addStatus", true);
		return "addarticle";
	}
	
	@Autowired
	private UploadService uploadService;
	
	@PostMapping("/article/save")
	public String actionSave(@RequestParam("file") MultipartFile file, 
			@Valid Article article, BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("article", article);
			model.addAttribute("addStatus", true);
			return "addarticle";
		}
		String thumbnail = uploadService.upload(file);
		article.setThumbnail(thumbnail);
		
		if(articleService.save(article)){
			System.out.println("Success!");
		}
		return "redirect:/article";
	}
	
	@GetMapping("/article/edit/{id}")
	public String saveArticlePage(@PathVariable("id") Integer id, ModelMap model){
		model.addAttribute("article", articleService.findOne(id));
		model.addAttribute("addStatus", false);
		return "addarticle";
	}
	
	@PostMapping("/article/update")
	public String actionUpdate(Article article, BindingResult result){
		if(result.hasErrors()){
			return "redirect:/article";
		}
		if(articleService.update(article)){
			System.out.println("success!");
		}
		return "redirect:/article";
	}
}