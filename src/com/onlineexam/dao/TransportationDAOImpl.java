package com.onlineexam.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.Transportation;

@Repository

public class TransportationDAOImpl implements TransportationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveTransportation(Transportation transportation) {
		sessionFactory.getCurrentSession().merge(transportation);

	}
	
@Override
	public void removeTransportation(Transportation transportation) {
	Transportation id = (Transportation) sessionFactory.getCurrentSession().load(Transportation.class,
			transportation);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}

	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer Id = (Integer) sessionFactory.getCurrentSession()
				.createQuery("from  transportation ORDER BY Registration_no DESC").setMaxResults(1).uniqueResult();

		return Id;

	}

	@Override
	public void updateTransportation(Transportation  transportation) {
		// TODO Auto-generated method stub
		
	}


}


