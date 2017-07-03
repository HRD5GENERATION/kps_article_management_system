package com.kps.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kps.model.Article;
import com.kps.service.ArticleService;
import com.kps.service.upload.FileUploadService;

@Controller
public class ArticleController {
	
	private ArticleService articleService;
	private FileUploadService uploadService;
	
	@Autowired
	public ArticleController(ArticleService articleService, FileUploadService uploadService) {
		this.articleService = articleService;
		this.uploadService = uploadService;	
	}
	
	@GetMapping({"/", "/home", "/index", "/article"})
	public String homePage(ModelMap model){
		model.addAttribute("articles", articleService.findAll());
		return "article";
	}

	@GetMapping(value="/article/view", params="id")
	public String detailPage(ModelMap model, @RequestParam("id") Integer id){
		Article article = articleService.findOne(id);
		model.addAttribute("article", article);
		return "articledetail";
	}
	
	@GetMapping("/article/{id}")
	public String detailPage1(ModelMap model, @PathVariable("id") Integer id){
		Article article = articleService.findOne(id);
		model.addAttribute("article", article);
		return "articledetail";
	}
	
	@GetMapping("/article/remove/{id}")
	public String remove(ModelMap model, @PathVariable("id") Integer id){
		if(articleService.remove(id)){
			System.out.println("success!");
		}
		return "redirect:/article";
	}
	
	@PostMapping("/article/save")
	public String save(@RequestParam("file") MultipartFile file, 
					   @Valid Article article, BindingResult result, ModelMap model){
		
		if(result.hasErrors()){
			model.addAttribute("article", article);
			model.addAttribute("addStatus", true);
			return "addarticle";
		}
		
		String thumbnail = uploadService.upload(file);
		article.setThumbnail(thumbnail);
		
		if(articleService.save(article)){
			System.out.println("success!");
		}
		return "redirect:/article";
	}
	
	@GetMapping("/article/add")
	public String addPage(ModelMap model){
		model.addAttribute("article", new Article());
		model.addAttribute("addStatus", true);
		return "addarticle";
	}	
	
	@GetMapping("/article/edit/{id}")
	public String editPage(@PathVariable("id") Integer id, ModelMap model){
		model.addAttribute("article", articleService.findOne(id));
		model.addAttribute("addStatus", false);
		return "addarticle";
	}	
	
	@PostMapping("/article/update")
	public String update(@RequestParam("file") MultipartFile file,
				@Valid @ModelAttribute("article") Article article, BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("article", article);
			model.addAttribute("addStatus", false);
			return "addarticle";
		}
		if(file.getSize() != 0){
			String thumbnail = uploadService.upload(file);
			article.setThumbnail(thumbnail);
		}
		if(articleService.update(article)){
			System.out.println("success!");
		}
		return "redirect:/article";
	}
}