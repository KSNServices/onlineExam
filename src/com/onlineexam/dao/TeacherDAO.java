package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.Teacher;

public interface TeacherDAO {
	
public Integer getId();
	
	public void saveTeacher(Teacher teacher);
	
	
	public void removeTeacher(Integer teacherId);
	
	public void updateTeacher(Teacher teacher);

	public List<Teacher> listTeacher(int adminId, int schoolId);

	public Teacher getTeacherById(Integer lastTeacherId);

	public String getLastTeacherId(int adminId, int schoolId);

	public	Teacher getTeacherByTeacherId(String id);

	

}
