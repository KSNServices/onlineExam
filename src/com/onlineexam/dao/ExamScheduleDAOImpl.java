package com.onlineexam.dao;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.ExamSchedule;

@Repository

public class ExamScheduleDAOImpl implements ExamScheduleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveExamSchedule(ExamSchedule exam_schedule) {
		sessionFactory.getCurrentSession().merge(exam_schedule);

	}
	
@Override
	public void removeExamSchedule(ExamSchedule exam_schedule) {
	ExamSchedule id = (ExamSchedule) sessionFactory.getCurrentSession().load(ExamSchedule.class,
			exam_schedule);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}

	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer Id = (Integer) sessionFactory.getCurrentSession()
				.createQuery("from exam_schedule ORDER BY Registration_no DESC").setMaxResults(1).uniqueResult();

		return Id;

	}

	@Override
	public void updateExamSchedule(ExamSchedule exam_schedule) {
		// TODO Auto-generated method stub
		
	}


}


