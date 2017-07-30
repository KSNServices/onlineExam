package com.onlineexam.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.ExamMarks;

@Repository

public class ExamMarksDAOImpl implements ExamMarksDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveExamMarks(ExamMarks exam_marks) {
		sessionFactory.getCurrentSession().merge(exam_marks);

	}
	
@Override
	public void removeExamMarks(ExamMarks exam_marks) {
	ExamMarks id = (ExamMarks) sessionFactory.getCurrentSession().load(ExamMarks.class,
			exam_marks);
		if (null != id) {
			sessionFactory.getCurrentSession().delete(id);
		}

	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		Integer Id = (Integer) sessionFactory.getCurrentSession()
				.createQuery("from  exam_marks ORDER BY Registration_no DESC").setMaxResults(1).uniqueResult();

		return Id;

	}

	@Override
	public void updateExamMarks(ExamMarks exam_marks) {
		// TODO Auto-generated method stub
		
	}


}


