package com.onlineexam.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.OnlineExamSubjects;

@Repository
public class OnlineExamSubjectDAOImpl implements OnlineExamSubjectDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<OnlineExamSubjects> listOnlineExamSubjects() {
		Query query = sessionFactory.getCurrentSession().createQuery("from OnlineExamSubjects");
		List<OnlineExamSubjects> oeSubjectsList = query.list(); 
		return oeSubjectsList;
	}

	@Override
	public void saveOnlineExamSubject(OnlineExamSubjects oeSubject) {
		sessionFactory.getCurrentSession().merge(oeSubject);
	}

	@Override
	public OnlineExamSubjects getOnlineExamSubjectById(Integer oeSbjectId) {
		return (OnlineExamSubjects)sessionFactory.getCurrentSession().get(OnlineExamSubjects.class,oeSbjectId);
	}

}
