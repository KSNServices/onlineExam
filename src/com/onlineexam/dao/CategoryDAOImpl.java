package com.onlineexam.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.Categories;
import com.onlineexam.model.PaymentPlan;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveCategory(Categories categories) {
		sessionFactory.getCurrentSession().merge(categories);
	}

	@Override
	public List<Categories> listCategory() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Categories");
		List<Categories> categoriesList = query.list(); 
		return categoriesList;
	}

	@Override
	public void removeCategory(Integer categoryId) {
		Categories categories = (Categories) sessionFactory.getCurrentSession().load(Categories.class, categoryId);
		if (null != categories) {
			sessionFactory.getCurrentSession().delete(categories);
		}
	}

	@Override
	public Categories getCategoryById(Integer categoryId) {
		return (Categories) sessionFactory.getCurrentSession().get(Categories.class, categoryId);
	}
	
	

}
