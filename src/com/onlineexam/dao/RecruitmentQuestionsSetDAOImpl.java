package com.onlineexam.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onlineexam.model.RecruitmentQuestionsSets;

@Repository
public class RecruitmentQuestionsSetDAOImpl implements RecruitmentQuestionsSetDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<RecruitmentQuestionsSets> listOnlineExamSets() {
		List<RecruitmentQuestionsSets> oeSetsList = sessionFactory.getCurrentSession().createQuery("From RecruitmentQuestionsSets").list();
		return oeSetsList;
	}
}
