package com.onlineexam.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.ApplicationForm;

@Repository
public class ApplicationFormDAOImpl implements ApplicationFormDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ApplicationForm> listApplicant() {
		List<ApplicationForm> applicantList =   sessionFactory.getCurrentSession().createQuery("form ApplicationForm").list();
		return applicantList;
	}
	
	
	

}
