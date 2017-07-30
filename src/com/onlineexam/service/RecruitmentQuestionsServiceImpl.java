package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.RecruitmentQuestionsDAO;
import com.onlineexam.model.RecruitmentQuestions;

@Service
public class RecruitmentQuestionsServiceImpl implements RecruitmentQuestionsService{
	
	@Autowired
	private RecruitmentQuestionsDAO recruitmentQuestionsDAO;

	@Override
	@Transactional
	public List<RecruitmentQuestions> listRecruitmentQuestions() {
		return recruitmentQuestionsDAO.listRecruitmentQuestions();
	}
	
	

}
