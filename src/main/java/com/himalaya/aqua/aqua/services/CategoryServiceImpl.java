package com.himalaya.aqua.aqua.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himalaya.aqua.aqua.core.entity.Category;
import com.himalaya.aqua.aqua.core.exception.HimalayaAquaException;
import com.himalaya.aqua.aqua.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository catrgoryRepository;

	@Override
	public void delete(Long id) throws HimalayaAquaException {
		catrgoryRepository.deleteById(id);
	}

	@Override
	public List<Category> find() throws HimalayaAquaException {
		List<Category> list = catrgoryRepository.findAll();
		if (list == null || list.size() < 1) {
			throw new HimalayaAquaException("The specified entity not found");
		}
		return list;
	}

	@Override
	public Category findById(Long id) throws HimalayaAquaException {
		Category category = catrgoryRepository.findById(id).orElse(null);
		if (category == null) {
			throw new HimalayaAquaException("The specified entity not found");
		}
		return category;
	}

	@Override
	public Long save(Category category) throws HimalayaAquaException {
		return catrgoryRepository.save(category).getId();
	}
}
