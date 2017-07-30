package com.onlineexam.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class InstituteDAOImpl implements InstituteDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	

}
