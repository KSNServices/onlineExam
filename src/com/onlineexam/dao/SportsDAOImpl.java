package com.onlineexam.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.Sports;

@Repository

public class SportsDAOImpl implements SportsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveSports(Sports sports) {
		sessionFactory.getCurrentSession().merge(sports);

	}
	
@Override
	public void removeSports(Sports sports) {
	Sports id = (Sports) sessionFactory.getCurrentSession().load(Sports.class,
			sports);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}

	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer Id = (Integer) sessionFactory.getCurrentSession()
				.createQuery("from  sports ORDER BY Registration_no DESC").setMaxResults(1).uniqueResult();

		return Id;

	}

	@Override
	public void updateSports(Sports sports) {
		// TODO Auto-generated method stub
		
	}


}


