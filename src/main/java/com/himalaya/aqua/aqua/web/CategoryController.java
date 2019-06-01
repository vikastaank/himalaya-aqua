package com.himalaya.aqua.aqua.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.himalaya.aqua.aqua.core.entity.Category;
import com.himalaya.aqua.aqua.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping
	public List<Category> find() {
		return categoryService.find();
	}

	@GetMapping(value = "/{categoryId}")
	public Category findById(@PathVariable("categoryId") Long categoryId) {
		return categoryService.findById(categoryId);
	}

	@PostMapping
	public Long save(@RequestBody Category category) {
		return categoryService.save(category);
	}

}
