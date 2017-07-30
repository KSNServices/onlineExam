

package com.onlineexam.service;

import java.util.List;


import com.onlineexam.model.TeacherGrade;

public interface TeacherGradeService {



	public	TeacherGrade getTeacherGradeById(Integer teacherGradeId);

	public	List<TeacherGrade> listTeacherGrade(int adminId, int schoolId);




	public	TeacherGrade listTeacherGradePresent(int adminId, int schoolId, String teacherGradePresent);

	public	void saveTeacherGrade(TeacherGrade teacherGrade);

	public	void removeTeacherGrade(TeacherGrade teacherGradeId);

	
	
	
}
