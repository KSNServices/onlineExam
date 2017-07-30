package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.OnlineExamSubjectDAO;
import com.onlineexam.model.OnlineExamSubjects;

@Service
public class OnlineExamSubjectServiceImpl implements OnlineExamSubjectService{
	
	@Autowired
	private OnlineExamSubjectDAO onlineExamSubjectDAO;

	@Override
	@Transactional
	public List<OnlineExamSubjects> listOnlineExamSubjects() {
		return onlineExamSubjectDAO.listOnlineExamSubjects();
	}

	@Override
	@Transactional
	public void saveOnlineExamSubject(OnlineExamSubjects oeSubject) {
		onlineExamSubjectDAO.saveOnlineExamSubject(oeSubject);
	}

	@Override
	@Transactional
	public OnlineExamSubjects getOnlineExamSubjectById(Integer oeSbjectId) {
		return onlineExamSubjectDAO.getOnlineExamSubjectById(oeSbjectId);
	}
	
	

}
