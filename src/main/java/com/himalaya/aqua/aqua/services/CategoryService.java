package com.himalaya.aqua.aqua.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.himalaya.aqua.aqua.core.entity.Category;

@Service
public interface CategoryService {

	List<Category> find();

	Category findById(Long categoryId);

	Long save(Category category);

}
