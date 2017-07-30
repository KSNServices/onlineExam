package com.onlineexam.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.Committee;

@Repository

public class CommitteeDAOImpl implements CommitteeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveCommittee(Committee committee) {
		sessionFactory.getCurrentSession().merge(committee);

	}
	
@Override
	public void removeCommittee(Committee committee) {
	Committee id = (Committee) sessionFactory.getCurrentSession().load(Committee.class,
			 committee);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}

	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer Id = (Integer) sessionFactory.getCurrentSession()
				.createQuery("from  committee ORDER BY Registration_no DESC").setMaxResults(1).uniqueResult();

		return Id;

	}

	@Override
	public void updateCommittee(Committee committee) {
		// TODO Auto-generated method stub
		
	}


}


