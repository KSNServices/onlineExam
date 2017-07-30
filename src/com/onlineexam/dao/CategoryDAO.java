package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.Categories;

public interface CategoryDAO {

	public void saveCategory(Categories categories);

	public List<Categories> listCategory();

	public void removeCategory(Integer categoryId);

	public Categories getCategoryById(Integer categoryId);

}
