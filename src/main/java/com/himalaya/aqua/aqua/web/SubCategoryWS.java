package com.himalaya.aqua.aqua.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.himalaya.aqua.aqua.core.basic.ResultVO;
import com.himalaya.aqua.aqua.core.entity.SubCategory;
import com.himalaya.aqua.aqua.core.exception.HimalayaAquaException;
import com.himalaya.aqua.aqua.services.SubCategoryService;

@RestController
@RequestMapping("/subcategories")
public class SubCategoryWS {

	public static final String RESPONSE_FAILURE = "FAILURE";

	@Autowired
	SubCategoryService subCategoryService;

	@DeleteMapping(value = "/{subCategoryId}")
	public void delete(@PathVariable("subCategoryId") Long subCategoryId) throws HimalayaAquaException {
		subCategoryService.delete(subCategoryId);
	}

	@GetMapping
	public ResultVO<List<SubCategory>> find() throws HimalayaAquaException {
		return new ResultVO<List<SubCategory>>(subCategoryService.find());
	}

	@GetMapping(value = "/{subCategoryId}")
	public ResultVO<SubCategory> findById(@PathVariable("subCategoryId") Long subCategoryId)
			throws HimalayaAquaException {
		return new ResultVO<SubCategory>(subCategoryService.findById(subCategoryId));
	}

	@PostMapping
	public Long save(@RequestBody SubCategory subCategory) throws HimalayaAquaException {
		return subCategoryService.save(subCategory);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResultVO<Object> handleNotFoundException(IllegalArgumentException ex) {
		ResultVO<Object> resultVO = new ResultVO<>();
		resultVO.setStatus(RESPONSE_FAILURE);
		resultVO.setStatusCode(500);
		resultVO.setStatusMsg(ex.getMessage());
		ex.printStackTrace();
		return resultVO;
	}
}
