package com.kps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kps.model.Article;
import com.kps.service.ArticleService;

//@RestController //@Controller + @ResponseBody
@Controller
public class AjaxController {
	
	@Autowired
	private ArticleService service;
	
	@ResponseBody
	@GetMapping("/ajax")
	public List<Article> ajax(){
		return service.findAll();
	}
	
	@GetMapping("/ajaxfragment")
	public String ajaxFragment(Model model){
		model.addAttribute("articles", service.findAll());
		return "article :: atfragment";
	}
	
	
	@GetMapping("/ajaxhome")
	public String ajaxHome(){
		return "ajax/index";
	}
	
}
