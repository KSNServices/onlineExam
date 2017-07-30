
package com.onlineexam.dao;

import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.onlineexam.model.ClassName;
import com.onlineexam.model.StudentFeeDetail;


@Repository
public class ClassNameDAOImpl implements ClassNameDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public List<ClassName> listClassName(int adminId ,int schoolId) {
		
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(ClassName.class);
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		List<ClassName> classNameList = cr.list();
		
		
		
		
		return classNameList;
	}
	
	
	
	@Override
	public ClassName listClassNamePresent(int adminId ,int schoolId , String classPresent) {
		
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(ClassName.class);
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		cr.add(Restrictions.eq("classPresent",classPresent));
		List<ClassName> classNameList = cr.list();
		
		ClassName className = null;
		if(classNameList.size()>0){
			className = (ClassName)cr.list().get(0);	
		}		
		return className;
		
		
		
	}

	@Override
	public void saveClassName(ClassName className) {
		sessionFactory.getCurrentSession().merge(className);
		
	}

	@Override
	public ClassName getClassNameById(Integer classNameId) {
		return (ClassName) sessionFactory.getCurrentSession().get(ClassName.class, classNameId);
	}
	
	

}
