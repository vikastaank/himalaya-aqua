package com.himalaya.aqua.aqua.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.himalaya.aqua.aqua.core.entity.Category;
import com.himalaya.aqua.aqua.core.exception.HimalayaAquaException;

@Service
public interface CategoryService {

	void delete(Long id) throws HimalayaAquaException;

	List<Category> find() throws HimalayaAquaException;

	Category findById(Long id) throws HimalayaAquaException;

	Long save(Category category) throws HimalayaAquaException;
}
