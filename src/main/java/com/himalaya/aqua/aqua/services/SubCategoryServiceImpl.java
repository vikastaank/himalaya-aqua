package com.himalaya.aqua.aqua.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.himalaya.aqua.aqua.core.entity.SubCategory;
import com.himalaya.aqua.aqua.core.exception.HimalayaAquaException;
import com.himalaya.aqua.aqua.dao.SubCategoryDao;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
	private SubCategoryDao subCategoryDao;

	@Override
	public void delete(Long id) throws HimalayaAquaException {
		subCategoryDao.deleteById(id);
	}

	@Override
	public List<SubCategory> find() throws HimalayaAquaException {
		List<SubCategory> list = subCategoryDao.findAll();
		if (list == null || list.size() < 1) {
			throw new HimalayaAquaException("The specified entity not found");
		}
		return list;
	}

	@Override
	public SubCategory findById(Long id) throws HimalayaAquaException {
		SubCategory subCategory = subCategoryDao.findById(id).orElse(null);
		if (subCategory == null) {
			throw new HimalayaAquaException("The specified entity not found");
		}
		return subCategory;
	}

	@Override
	public Long save(SubCategory subCategory) throws HimalayaAquaException {
		return subCategoryDao.save(subCategory).getId();
	}
}
