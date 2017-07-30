


package com.onlineexam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.onlineexam.dao.TeacherGradeDAO;
import com.onlineexam.model.TeacherGrade;


@Service
public class TeacherGradeServiceImpl implements TeacherGradeService{
	
	@Autowired
	private TeacherGradeDAO teacherGradeDAO;


	
	
	@Override
	@Transactional
	public void saveTeacherGrade(TeacherGrade teacherGrade) {
		teacherGradeDAO.saveTeacherGrade(teacherGrade);
	}

	@Override
	@Transactional
	public TeacherGrade getTeacherGradeById(Integer teacherGradeId) {
		return teacherGradeDAO.getTeacherGradeById(teacherGradeId);
	}
	
	


	@Override
	@Transactional
	public List<TeacherGrade> listTeacherGrade(int adminId, int schoolId) {
		return teacherGradeDAO.listTeacherGrade(adminId, schoolId);
	}
	
	

	@Override
	@Transactional
	public TeacherGrade listTeacherGradePresent(int adminId, int schoolId, String teacherGradePresent) {
		return teacherGradeDAO.listTeacherGradePresent(adminId, schoolId, teacherGradePresent);
	}

	@Override
	@Transactional
	public void removeTeacherGrade(TeacherGrade teacherGradeId) {
		 teacherGradeDAO.removeTeacherGrade(teacherGradeId);
	}
	

}
