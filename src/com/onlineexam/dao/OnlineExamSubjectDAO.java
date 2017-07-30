package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.OnlineExamSubjects;

public interface OnlineExamSubjectDAO {

	public List<OnlineExamSubjects> listOnlineExamSubjects();

	public void saveOnlineExamSubject(OnlineExamSubjects oeSubject);

	public OnlineExamSubjects getOnlineExamSubjectById(Integer oeSbjectId);

}
