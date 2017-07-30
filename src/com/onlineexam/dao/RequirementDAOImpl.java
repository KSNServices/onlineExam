package com.onlineexam.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.Requirement;

@Repository

public class RequirementDAOImpl implements RequirementDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveRequirement(Requirement requirement) {
		sessionFactory.getCurrentSession().merge(requirement);

	}
	
@Override
	public void removeRequirement(Requirement requirement) {
	Requirement id = (Requirement) sessionFactory.getCurrentSession().load(Requirement.class,
			requirement);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}

	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer Id = (Integer) sessionFactory.getCurrentSession()
				.createQuery("from  requirement ORDER BY Registration_no DESC").setMaxResults(1).uniqueResult();

		return Id;

	}

	@Override
	public void updateRequirement(Requirement requirement) {
		// TODO Auto-generated method stub
		
	}


}



