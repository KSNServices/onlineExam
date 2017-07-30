package com.onlineexam.dao;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.ExtraActivities;

@Repository

public class ExtraActivitiesDAOImpl implements ExtraActivitiesDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveExtraActivities(ExtraActivities extra_activities) {
		sessionFactory.getCurrentSession().merge(extra_activities);

	}
	
@Override
	public void removeExtraActivities(ExtraActivities extra_activities) {
	ExtraActivities id = (ExtraActivities) sessionFactory.getCurrentSession().load(ExtraActivities.class,
			extra_activities);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}

	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer Id = (Integer) sessionFactory.getCurrentSession()
				.createQuery("from  extra_activities ORDER BY Registration_no DESC").setMaxResults(1).uniqueResult();

		return Id;

	}

	@Override
	public void updateExtraActivities(ExtraActivities extra_activities) {
		// TODO Auto-generated method stub
		
	}


}



