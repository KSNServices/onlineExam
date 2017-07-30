package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.ExamSchedule;

public interface ExamScheduleDAO {
	
public Integer getId();
	
	public void saveExamSchedule(ExamSchedule exam_schedule);
	
	
	public void removeExamSchedule(ExamSchedule exam_schedule);
	
	public void updateExamSchedule(ExamSchedule exam_schedule);

}
