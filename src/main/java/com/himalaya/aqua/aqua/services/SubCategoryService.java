package com.himalaya.aqua.aqua.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.himalaya.aqua.aqua.core.entity.SubCategory;
import com.himalaya.aqua.aqua.core.exception.HimalayaAquaException;

@Service
public interface SubCategoryService {
	void delete(Long id) throws HimalayaAquaException;

	List<SubCategory> find() throws HimalayaAquaException;

	SubCategory findById(Long id) throws HimalayaAquaException;

	Long save(SubCategory category) throws HimalayaAquaException;
}
