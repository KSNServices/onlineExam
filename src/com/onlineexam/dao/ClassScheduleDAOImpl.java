package com.onlineexam.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.ClassSchedule;

@Repository

public class ClassScheduleDAOImpl implements ClassScheduleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveClassSchedule(ClassSchedule class_schedule) {
		sessionFactory.getCurrentSession().merge(class_schedule);

	}
	
@Override
	public void removeClassSchedule(ClassSchedule class_schedule) {
	ClassSchedule id = (ClassSchedule) sessionFactory.getCurrentSession().load(ClassSchedule.class,
				class_schedule);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}

	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer Id = (Integer) sessionFactory.getCurrentSession()
				.createQuery("from class_schedule ORDER BY Registration_no DESC").setMaxResults(1).uniqueResult();

		return Id;

	}

	@Override
	public void updateClassSchedule(ClassSchedule class_schedule) {
		// TODO Auto-generated method stub
		
	}


}

