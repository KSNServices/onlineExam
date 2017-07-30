package com.onlineexam.service;

import java.util.List;

import com.onlineexam.model.Teacher;

public interface TeacherFormService {

	public void saveTeacher(Teacher teacher);

	public List<Teacher> listTeacher(int adminId, int schoolId);

	public void removeTeacher(Integer teacherId);

	public void getLastTeacherById(Integer Id);

	public Teacher getteacherById(Integer Id);

	Teacher getTeacherById(Integer lastTeacherId);

	public String getLastTeacherId(int adminId, int schoolId);
	
	public	Teacher getTeacherByTeacherId(String id);

}
