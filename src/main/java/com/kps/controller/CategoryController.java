package com.kps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kps.model.Category;
import com.kps.repository.CategoryRepository;

@RestController
public class CategoryController {

	@Autowired
	private CategoryRepository cRepo;
	
	@GetMapping("/category")
	public List<Category> findAll(){
		return cRepo.findAll();
	}
	
}
