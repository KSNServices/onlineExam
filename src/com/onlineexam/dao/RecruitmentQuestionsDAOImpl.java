package com.onlineexam.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.RecruitmentQuestions;

@Repository
public class RecruitmentQuestionsDAOImpl implements RecruitmentQuestionsDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<RecruitmentQuestions> listRecruitmentQuestions() {
		List<RecruitmentQuestions> rqList = sessionFactory.getCurrentSession().createQuery("FROM RecruitmentQuestions").list();
		return rqList;
	}
	
	
	
	

}
