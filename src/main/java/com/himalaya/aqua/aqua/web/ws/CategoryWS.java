package com.himalaya.aqua.aqua.web.ws;

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
import com.himalaya.aqua.aqua.core.entity.Category;
import com.himalaya.aqua.aqua.core.exception.HimalayaAquaException;
import com.himalaya.aqua.aqua.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryWS {

	public static final String RESPONSE_FAILURE = "FAILURE";

	@Autowired
	CategoryService categoryService;

	@DeleteMapping(value = "/{categoryId}")
	public void delete(@PathVariable("categoryId") Long categoryId) throws HimalayaAquaException {
		categoryService.delete(categoryId);
	}

	@GetMapping
	public ResultVO<List<Category>> find() throws HimalayaAquaException {
		return new ResultVO<List<Category>>(categoryService.find());
	}

	@GetMapping(value = "/{categoryId}")
	public ResultVO<Category> findById(@PathVariable("categoryId") Long categoryId) throws HimalayaAquaException {
		return new ResultVO<Category>(categoryService.findById(categoryId));
	}

	@PostMapping
	public Long save(@RequestBody Category category) throws HimalayaAquaException {
		return categoryService.save(category);
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
