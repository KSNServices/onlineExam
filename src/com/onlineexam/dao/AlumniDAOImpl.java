package com.onlineexam.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.AdmissionFormModel;
import com.onlineexam.model.Alumni;

@Repository

public class AlumniDAOImpl implements AlumniDAO {
	
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveAlumni(Alumni alumni) {
		sessionFactory.getCurrentSession().merge(alumni);

	}

	@Override
	public void removeAlumni(Alumni alumni) {
		Alumni id = (Alumni) sessionFactory.getCurrentSession().load(Alumni.class,
				alumni);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}

	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer Id = (Integer) sessionFactory.getCurrentSession()
				.createQuery("from alumni ORDER BY Registration_no DESC").setMaxResults(1).uniqueResult();

		return Id;

	}

	@Override
	public void updateAlumni(Alumni alumni) {
		// TODO Auto-generated method stub
		
	}
}
