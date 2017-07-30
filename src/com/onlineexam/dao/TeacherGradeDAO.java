


package com.onlineexam.dao;

import java.util.List;


import com.onlineexam.model.TeacherGrade;

public interface TeacherGradeDAO {

	public	List<TeacherGrade> listTeacherGrade(int adminId, int schoolId);





	public	void saveTeacherGrade(TeacherGrade teacherGrade);



	public	TeacherGrade getTeacherGradeById(Integer teacherGradeId);





	public	void removeTeacherGrade(TeacherGrade id);





	public	TeacherGrade listTeacherGradePresent(int adminId, int schoolId, String teacherGrade);

	
	

}
