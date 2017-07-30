
package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.dao.TeacherDAO;
import com.onlineexam.model.Teacher;


@Service
public class TeacherFormServiceImpl implements TeacherFormService {

	@Autowired
	private TeacherDAO teacherDAO;
	
	

	@Override
	@Transactional
	public void saveTeacher(Teacher teacher) {
		teacherDAO.saveTeacher(teacher);
		
	}

	@Override
	@Transactional
	public List<Teacher> listTeacher(int adminId, int schoolId) {
		return teacherDAO.listTeacher(adminId,schoolId);
		
	}

	@Override
	@Transactional
	public void removeTeacher(Integer teacherId) {
		teacherDAO.removeTeacher(teacherId);
		
	}

	@Override
	@Transactional
	public void getLastTeacherById(Integer lastTeacherId) {
		lastTeacherId=  teacherDAO.getId();
		
	}

	@Override
	@Transactional
	public Teacher getTeacherById(Integer lastTeacherId) {
		return teacherDAO.getTeacherById(lastTeacherId);}

	@Override
	@Transactional
	public Teacher getteacherById(Integer Id) {
		return teacherDAO.getTeacherById(Id);}
	
	@Override
	@Transactional
	public String getLastTeacherId(int adminId, int schoolId) {
	
	return teacherDAO.getLastTeacherId(adminId,schoolId);}
	
	
	@Override
	@Transactional
	public Teacher getTeacherByTeacherId(String Id) {
		return teacherDAO.getTeacherByTeacherId(Id);}


}
