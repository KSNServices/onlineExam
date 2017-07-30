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


@Repository
public class FeeStructureDAOImpl implements FeeStructureDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveFeeStructure(FeeStructure feeStructure) {
		sessionFactory.getCurrentSession().merge(feeStructure);

	}
	
	@Override
	public void removeFeeStructure(FeeStructure id) {
		
	sessionFactory.getCurrentSession().delete(id);

	}

	@Override
	public List<FeeStructure> listFeeStructure(int adminId, int schoolId, String classValue ,String section) {
		
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(FeeStructure.class);
		cr.add(Restrictions.eq("schoolId.id",schoolId));
		cr.add(Restrictions.eq("adminId.id",adminId));
		cr.add(Restrictions.eq("className",classValue));
		cr.add(Restrictions.eq("classSection",section));
		List<FeeStructure> feeStructure = cr.list();
		return feeStructure;
	}

	@Override
	public void updateFeeStructure(FeeStructure fee_structure) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public FeeStructure getFeeById(Integer id) {
	
		FeeStructure idDetail = (FeeStructure)  sessionFactory.getCurrentSession().get(FeeStructure.class,id);
	
		return idDetail;

	}

	@Override
	public  Double getFeeClass(int adminId, int schoolId, String classvalue, String section) {
			
			
			
			Criteria cr = sessionFactory.getCurrentSession().createCriteria(FeeStructure.class);
			ProjectionList pro = Projections.projectionList();
			pro.add(Projections.sum("amount"));
			cr.add(Restrictions.eq("schoolId.id",schoolId));
			cr.add(Restrictions.eq("adminId.id",adminId));
			cr.add(Restrictions.eq("classSection",section));
			cr.add(Restrictions.eq("className",classvalue));
			cr.setProjection(pro);
			Double number = (Double)cr.uniqueResult();
			
		return number;
			
			
			
		}
		
	



}




