

package com.onlineexam.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.FeeStructure;
import com.onlineexam.model.SalaryStructure;


@Repository

public class SalaryStructureDAOImpl implements SalaryStructureDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveSalary(SalaryStructure salaryStructure) {
		sessionFactory.getCurrentSession().merge(salaryStructure);

	}
	
	@Override
	public void removeSalary(SalaryStructure salaryStructure) {
	
			sessionFactory.getCurrentSession().delete(salaryStructure);
		

	}
	

	@Override
	public List<SalaryStructure> listSalaryStructure(int adminId, int schoolId, String teacherGrade) {
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(SalaryStructure.class);
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		cr.add(Restrictions.eq("teacherGrade",teacherGrade));
		List<SalaryStructure> salaryStructure = cr.list();
		return salaryStructure;
	}

	@Override
	public Double sumSalaryStructure(int adminId, int schoolId, String teacherGrade) {
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(SalaryStructure.class);
		ProjectionList pro = Projections.projectionList();
		pro.add(Projections.sum("amount"));
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		cr.add(Restrictions.eq("teacherGrade",teacherGrade));
		cr.setProjection(pro);
		Double number = (Double)cr.uniqueResult();
		
	return number;
		
	}
	
	@Override
	public SalaryStructure getSalaryById(Integer id) {
	
		SalaryStructure idDetail = (SalaryStructure)  sessionFactory.getCurrentSession().get(SalaryStructure.class,id);
	
		return idDetail;

	}

	





}



