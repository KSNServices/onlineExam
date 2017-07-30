package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.ExamMarks;

public interface ExamMarksDAO {
	
public Integer getId();
	
	public void saveExamMarks(ExamMarks exam_marks);
	
	
	public void removeExamMarks(ExamMarks exam_marks);
	
	
	public void updateExamMarks(ExamMarks exam_marks);

}
