package com.onlineexam.service;

import java.util.List;

import com.onlineexam.model.Categories;

public interface CategoryService {
	
	public void saveCategory(Categories categories);
	public List<Categories> listCategory();
	public void removeCategory(Integer categoryId);
	public Categories getCategoryById(Integer categoryId);

}
