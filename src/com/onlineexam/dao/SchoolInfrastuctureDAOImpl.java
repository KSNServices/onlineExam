package com.onlineexam.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.ExamMarks;
import com.onlineexam.model.SchoolInfrastructure;

@Repository

public class SchoolInfrastuctureDAOImpl implements SchoolInfrastructureDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveSchoolInfrastructure(SchoolInfrastructure school_infrastructure) {
		sessionFactory.getCurrentSession().merge(school_infrastructure);

	}
	
@Override
	public void removeSchoolInfrastructure(SchoolInfrastructure school_infrastructure) {
	SchoolInfrastructure id = (SchoolInfrastructure) sessionFactory.getCurrentSession().load(SchoolInfrastructure.class,
			school_infrastructure);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}

	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer Id = (Integer) sessionFactory.getCurrentSession()
				.createQuery("from  school_infrastructure ORDER BY Registration_no DESC").setMaxResults(1).uniqueResult();

		return Id;

	}

	@Override
	public void updateSchoolInfrastructure(SchoolInfrastructure school_infrastructure) {
		// TODO Auto-generated method stub
		
	}


}


