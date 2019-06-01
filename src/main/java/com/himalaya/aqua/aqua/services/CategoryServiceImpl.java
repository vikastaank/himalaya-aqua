package com.himalaya.aqua.aqua.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himalaya.aqua.aqua.core.entity.Category;
import com.himalaya.aqua.aqua.dao.CategoryDao;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Category> find() {
		return categoryDao.findAll();
	}

	@Override
	public Category findById(Long categoryId) {
		return categoryDao.findById(categoryId).orElse(null);
	}

	@Override
	public Long save(Category category) {
		return categoryDao.save(category).getId();
	}

}
