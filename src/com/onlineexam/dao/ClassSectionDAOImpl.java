

package com.onlineexam.dao;

import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.onlineexam.model.ClassName;
import com.onlineexam.model.ClassSection;


@Repository
public class ClassSectionDAOImpl implements ClassSectionDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	

	@Override
	public List<ClassSection> listClassSection(int adminId ,int schoolId , String classPresent) {
		
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(ClassSection.class);
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		cr.add(Restrictions.eq("classPresent",classPresent));
		List<ClassSection> classSectionList = cr.list();
		
		
		
		
		return classSectionList;
	}

	@Override
	public List<ClassSection> listClassSectionTotal(int adminId ,int schoolId ) {
		
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(ClassSection.class);
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		
		List<ClassSection> classSectionList = cr.list();
		
		
		
		
		return classSectionList;
	}
	

	@Override
	public ClassSection ClassSectionList(int adminId ,int schoolId , String classPresent , String classSectionValue) {
		
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(ClassSection.class);
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		cr.add(Restrictions.eq("classPresent",classPresent));
		cr.add(Restrictions.eq("classSectionValue",classSectionValue));
		List<ClassSection> classSectionList = cr.list();
		
		ClassSection classSection = null;
		if(classSectionList.size()>0){
			classSection = (ClassSection)cr.list().get(0);	
		}		
	
		
		
		return classSection;
	}
	
	
	
	

	
	

	@Override
	public void saveClassSection(ClassSection classSection) {
		sessionFactory.getCurrentSession().merge(classSection);
		
	}

	@Override
	public ClassSection getClassSectionById(Integer classSectionId) {
		return (ClassSection) sessionFactory.getCurrentSession().get(ClassSection.class, classSectionId);
	}


	
	

}
