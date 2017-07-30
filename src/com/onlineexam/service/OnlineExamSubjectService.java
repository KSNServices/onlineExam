package com.onlineexam.service;

import java.util.List;

import com.onlineexam.model.OnlineExamSubjects;

public interface OnlineExamSubjectService {

	public List<OnlineExamSubjects> listOnlineExamSubjects();

	public void saveOnlineExamSubject(OnlineExamSubjects oeSubject);

	public OnlineExamSubjects getOnlineExamSubjectById(Integer oeSbjectId);
	
	

}
