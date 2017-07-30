package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.CategoryDAO;
import com.onlineexam.model.Categories;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	@Transactional
	public void saveCategory(Categories categories) {
		categoryDAO.saveCategory(categories);
	}

	@Override
	@Transactional
	public List<Categories> listCategory() {
		return categoryDAO.listCategory();
	}

	@Override
	@Transactional
	public void removeCategory(Integer categoryId) {
		categoryDAO.removeCategory(categoryId);
	}

	@Override
	@Transactional
	public Categories getCategoryById(Integer categoryId) {
		return categoryDAO.getCategoryById(categoryId);
	}
	
	
	
}
