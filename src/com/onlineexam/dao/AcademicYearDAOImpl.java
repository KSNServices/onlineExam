package com.onlineexam.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.AcademicYear;

@Repository
public class AcademicYearDAOImpl implements AcademicYearDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<AcademicYear> listAcademicYear() {
		Query query = sessionFactory.getCurrentSession().createQuery("from AcademicYear");
		List<AcademicYear> academicYearList = query.list(); 
		return academicYearList;
	}

	@Override
	public void saveAcademicYear(AcademicYear academicYear) {
		sessionFactory.getCurrentSession().merge(academicYear);
	}

	@Override
	public AcademicYear getAcademicYearById(Integer academicYearId) {
		return (AcademicYear) sessionFactory.getCurrentSession().get(AcademicYear.class, academicYearId);
	}
	
	

}
